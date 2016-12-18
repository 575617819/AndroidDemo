package com.yh.broadcast.activity;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;

import com.yh.broadcast.R;
import com.yh.broadcast.receiver.NetworkReceiver;

public class MainActivity extends Activity {


    private NetworkReceiver networkReceiver;

    /*
     在onCreate方法中动态注册广播
     注意：动态注册的广播一定要取消注册（所以在oonDestroy方法中取消注册）
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter();
        //android.net.conn.CONNECTIVITY_CHANGE是网络发生变化时，系统发出的值
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkReceiver = new NetworkReceiver();
        registerReceiver(networkReceiver, intentFilter);

    }


    /*
    在onDestroy方法中取消注册广播接收者
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkReceiver);
    }
}
