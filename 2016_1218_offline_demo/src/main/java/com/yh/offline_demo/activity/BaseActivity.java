package com.yh.offline_demo.activity;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;

import com.yh.offline_demo.receiver.OfflineReceiver;
import com.yh.offline_demo.utils.ActivityCollector;

public class BaseActivity extends Activity {

    private OfflineReceiver offlineReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    /*
    重写onResume/onPause,用于实现动态注册和注销广播
     */
    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.yh.offline.ok");
        offlineReceiver = new OfflineReceiver();
        registerReceiver(offlineReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(offlineReceiver);
    }
}
