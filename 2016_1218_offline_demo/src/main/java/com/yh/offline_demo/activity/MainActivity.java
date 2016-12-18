package com.yh.offline_demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yh.offline_demo.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button offline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        offline = (Button) findViewById(R.id.bt_main_offline);
        offline.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        /*
        点击强制下线按钮，发送广播
         */
        Intent intent = new Intent("com.yh.offline.ok");
        sendBroadcast(intent);
    }

}
