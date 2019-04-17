package com.jd.business.http;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by weip on 2019/2/20.
 */

public class ThreadPoolManager {

    //1、创建队列,用户保存异步请求任务
    //先进先出
    private LinkedBlockingDeque<Runnable> mQuene = new LinkedBlockingDeque<>();

    //2、添加异步任务到队列中
    public void addTask(Runnable runnable) {
        if (runnable != null) {
            try {
                mQuene.put(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //3、创建线程池
    private ThreadPoolExecutor mThreadPoolExecutor;

    private ThreadPoolManager() {
        mThreadPoolExecutor = new ThreadPoolExecutor
                (3, 10, 15, TimeUnit.SECONDS,
                        new ArrayBlockingQueue<Runnable>(4), new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        //拒绝 处理抛出来的任务
                        addTask(r);
                    }
                });
        mThreadPoolExecutor.execute(communicateThread);
    }
    //创建队列与线程池的"交互线程"
    public Runnable communicateThread = new Runnable() {
        @Override
        public void run() {
            Runnable ruun = null;
            while (true){
                try {
                    ruun = mQuene.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mThreadPoolExecutor.execute(ruun);
            }
        }
    };

    private static ThreadPoolManager threadPoolManager = new ThreadPoolManager();

    private static ThreadPoolManager getInstance() {
        return threadPoolManager;
    }
}
