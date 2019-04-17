package com.jd.touchib;

/**
 * 普通经理
 * Created by weip on 2019/2/28.
 */

public class OrdinaryManager extends Manager{

    public OrdinaryManager() {
        super(Manager.ORDINARY_MANAGER);
    }

    @Override
    protected void response(Staff staff) {
        System.out.println("OrdinaryManager");
        System.out.println(staff.getRequest());
        System.out.println("OrdinaryManager回答ok");
        System.out.println("=========================");
    }
}
