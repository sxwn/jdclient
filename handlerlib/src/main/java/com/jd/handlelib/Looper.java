package com.jd.handlelib;

public class Looper {

    public MessageQuene mQuene;

    static ThreadLocal<Looper> sTheadLocal = new ThreadLocal<>();

    private Looper(){
        mQuene = new MessageQuene();
    }

    /**
     * 初始化Looper,并将其保存在sTheadLocal中
     */
    public static void prepare(){
        if (sTheadLocal.get()!=null){
            throw new RuntimeException("一个线程仅能拥有一个Looper");
        }
        sTheadLocal.set(new Looper());
    }

    /**
     * 获取当前对象的looper对象
     * @return
     */
    public static Looper myLooper(){
        return sTheadLocal.get();//保证返回的Looper对象是当前线程的Looper
    }

    public static void loop(){
        Looper me = myLooper();
        if (me==null){
            throw new RuntimeException("当前线程没有Looper对象,请调用prepare");
        }
        MessageQuene quene = me.mQuene;
        for(;;){
            Message msg = quene.next();
            if (msg!=null){
                msg.target.dispatchMessage(msg);
            }
        }
    }

}
