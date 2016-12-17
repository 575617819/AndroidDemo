package com.yh.customview_demo.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yh.customview_demo.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt1_main;
    private Button bt2_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        隐藏activity的标题栏
         */
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        /*
        跳转到Main2Acitvity和Main3Activiy,查看标题栏
         */
        initView();


    }

    private void initView() {
        bt1_main = (Button) findViewById(R.id.bt1_main);
        bt2_main = (Button) findViewById(R.id.bt2_main);

        bt1_main.setOnClickListener(this);
        bt2_main.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.bt1_main:
                Intent intent1 = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent1);
                break;
            case R.id.bt2_main:
                Intent intent2 = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }
}
