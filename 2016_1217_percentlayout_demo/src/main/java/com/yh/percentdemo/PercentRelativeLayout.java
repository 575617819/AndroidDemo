package com.yh.percentdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PercentRelativeLayout extends Activity implements View.OnClickListener {

    private Button bt1_percent;
    private Button bt2_percent;
    private Button bt3_percent;
    private Button bt4_percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percent_relative_layout);

         /*
        Android 百分比布局
         */
        initView();
    }

    private void initView() {
        bt1_percent = (Button) findViewById(R.id.bt1_percent);
        bt2_percent = (Button) findViewById(R.id.bt2_percent);
        bt3_percent = (Button) findViewById(R.id.bt3_percent);
        bt4_percent = (Button) findViewById(R.id.bt4_percent);

        bt1_percent.setOnClickListener(this);
        bt2_percent.setOnClickListener(this);
        bt3_percent.setOnClickListener(this);
        bt4_percent.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.bt1_percent:
                CharSequence bt1_percentText = bt1_percent.getText();
                showToast(bt1_percentText);
                break;
            case R.id.bt2_percent:
                CharSequence bt2_percentText = bt2_percent.getText();
                showToast(bt2_percentText);
                break;
            case R.id.bt3_percent:
                CharSequence bt3_percentText = bt3_percent.getText();
                showToast(bt3_percentText);
                break;
            case R.id.bt4_percent:
                CharSequence bt4_percentText = bt4_percent.getText();
                showToast(bt4_percentText);
                break;
        }
    }

    private void showToast(CharSequence bt1_percentText) {
        Toast.makeText(this,bt1_percentText,Toast.LENGTH_SHORT).show();
    }
}
