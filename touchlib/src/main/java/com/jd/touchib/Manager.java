package com.jd.touchib;

/**
 * Created by leader on 2019/2/28.
 */

public abstract class Manager {

    public final static int BOSS = 1;
    public final static int GENERAL_MANAGER = 2;
    public final static int ORDINARY_MANAGER = 3;

    public int level = 0;
    //下一个责任人
    private Manager nextManager;

    public Manager(int level){
        this.level = level;
    }

    public final void request(Staff staff){
        if (staff.getLevel() == level){
            this.response(staff);
        }else {
            if (nextManager != null){
                nextManager.request(staff);
            }else{
                System.out.println("加薪太多,都不处理");
                System.out.println("==================");
            }
        }
    }

    public void setNextManager(Manager nextManager){
        this.nextManager = nextManager;
    }

    protected abstract void response(Staff staff);
}
