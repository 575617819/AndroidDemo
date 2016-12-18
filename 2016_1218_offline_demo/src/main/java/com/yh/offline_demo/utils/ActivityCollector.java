package com.yh.offline_demo.utils;

import android.app.Activity;

import java.util.ArrayList;

/*
activity工具类
 */

class ActivityCollector {


    protected static ArrayList<Activity> arrayListActivitys = new ArrayList<Activity>();

    protected static void addActivity(Activity activity) {
        arrayListActivitys.add(activity);
    }

    protected static void removeActivity(Activity activity) {
        arrayListActivitys.remove(activity);
    }

    protected static void removeAllActivity() {
        for (Activity activity : arrayListActivitys) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

}
