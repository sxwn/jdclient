package com.jd.touchib;

/**
 * 老板
 * Created by weip on 2019/2/28.
 */

public class Boss extends Manager {
    public Boss() {
        super(Manager.BOSS);
    }

    @Override
    protected void response(Staff staff) {
        System.out.println("员工问Boss");
        System.out.println(staff.getRequest());
        System.out.println("boss回答ok");
        System.out.println("=========================");
    }
}
