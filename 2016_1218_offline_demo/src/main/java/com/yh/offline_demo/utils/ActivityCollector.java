package com.yh.offline_demo.utils;

import android.app.Activity;

import java.util.ArrayList;

/*
activity工具类
 */

public class ActivityCollector {

    public static ArrayList<Activity> arrayListActivitys = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        arrayListActivitys.add(activity);
    }

    public static void removeActivity(Activity activity) {
        arrayListActivitys.remove(activity);
    }

    public static void removeAllActivity() {
        for (Activity activity : arrayListActivitys) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
