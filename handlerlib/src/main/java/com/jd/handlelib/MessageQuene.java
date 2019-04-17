package com.jd.handlelib;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MessageQuene {
    //存储Message数组结构
    private Message[] items;
    //入队出队的索引位置
    private int putIndex;
    private int takeIndex;

    //计数器
    private int count;
    //锁
    private Lock lock;
    //条件变量
    private Condition notEmpty;
    private Condition notFull;

    public MessageQuene() {
        items = new Message[50];
        lock = new ReentrantLock();//可重入锁
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
    }

    /**
     * 将消息加入队列,生产者
     *
     * @param msg
     */
    public void enqueneMessage(Message msg) {
        //消息队列满了,等待消费
        try {
            lock.lock();
            while (count == 50) {
                notFull.await();
            }
            items[putIndex] = msg;
            putIndex = (++putIndex == items.length ? 0 : putIndex);
            count++;
            //已经生产了可以消费了
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    /**
     * 取出队列中的消息，消费者
     *
     * @return
     */
    public Message next() {
        Message msg = null;
        try {
            lock.lock();
            //消息为空了,等待生产
            while (count == 0) {
                notEmpty.await();
            }
            msg = items[takeIndex];
            items[takeIndex] = null;
            takeIndex = (++takeIndex == items.length ? 0 : takeIndex);
            count--;
            //已经消费了可以继续生产
            notFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return msg;
    }

}
