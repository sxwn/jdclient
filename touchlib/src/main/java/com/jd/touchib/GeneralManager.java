package com.jd.touchib;

/**
 * 总经理
 * Created by weip on 2019/2/28.
 */

public class GeneralManager extends Manager {

    public GeneralManager() {
        super(Manager.GENERAL_MANAGER);
    }

    @Override
    protected void response(Staff staff) {
        System.out.println("GeneralManager");
        System.out.println(staff.getRequest());
        System.out.println("GeneralManager回答ok");
        System.out.println("=========================");
    }
}
