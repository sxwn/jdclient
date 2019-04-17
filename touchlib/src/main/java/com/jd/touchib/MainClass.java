package com.jd.touchib;

import java.util.ArrayList;
import java.util.Random;

/**
 * 责任链模式
 * Created by weip on 2019/2/28.
 */

public class MainClass {

    public static void main(String[] args){
        Random random = new Random();
        ArrayList<Staff> arrayList = new ArrayList<>();
        for (int i=0;i<10;i++){
            arrayList.add(new Staff(random.nextInt(4),"我要加薪"));
        }
        Manager ordinaryManager = new OrdinaryManager();
        Manager generalManager = new GeneralManager();
        Manager boss = new Boss();

        ordinaryManager.setNextManager(generalManager);
        generalManager.setNextManager(boss);

        for (Staff staff :arrayList) {
            ordinaryManager.request(staff);
        }
    }
}
