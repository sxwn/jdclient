package com.jd.handlelib;

public class Handler {

    private MessageQuene mQuene;

    public Handler(){
        Looper mLooper = Looper.myLooper();
        mQuene = mLooper.mQuene;
    }

    /**
     * 发送消息,加入队列
     * @param msg
     */
    public void sendMessage(Message msg){
        msg.target = this;
        mQuene.enqueneMessage(msg);
    }

    /**
     * 处理消息
     * @param msg
     */
    public void handleMessage(Message msg){

    }

    /**
     * 分发消息
     * @param msg
     */
    public void dispatchMessage(Message msg){
        handleMessage(msg);
    }
}
