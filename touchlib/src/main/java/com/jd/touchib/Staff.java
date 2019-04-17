package com.jd.touchib;

/**
 * 员工类
 * Created by weip on 2019/2/28.
 */

public class Staff {

    //员工请求的等级
    private int level = 0;
    //员工请求内容
    private String request = "";

    public Staff(int level,String request){
        this.level = level;
        switch (level){
            case 1:
                this.request = "员工的请求是:"+request+"10000";
                break;
            case 2:
                this.request = "员工的请求是:"+request+"5000";
                break;
            case 3:
                this.request = "员工的请求是:"+request+"1000";
                break;
            default:
                this.request = "员工的请求是:"+request+"20000";
                break;
        }
    }

    public int getLevel() {
        return level;
    }

    public String getRequest() {
        return request;
    }
}
