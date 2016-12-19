package com.yh.handler;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    public final int UPDATE_TEXT = 1;
    public static boolean flag=true;

    private TextView tv_main_text;
    private Button bt_main_change;

    private Handler handler = new Handler() {

        public void handleMessage(Message message) {
            switch (message.what) {
                case UPDATE_TEXT:
                    if(flag){
                        tv_main_text.setText("我带上你，你带上钱，我们去看看世界");
                        tv_main_text.setTextColor(Color.BLUE);
                        flag=false;
                    }else {
                        tv_main_text.setText("世界这么大，我想去看看");
                        tv_main_text.setTextColor(Color.RED);
                        flag=true;
                    }

                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        初始化布局
         */
        initView();
    }

    private void initView() {
        tv_main_text = (TextView) findViewById(R.id.tv_main_text);
        bt_main_change = (Button) findViewById(R.id.bt_main_change);

        bt_main_change.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        /*
        在子线程中更新UI
        我们会发现程序报错： Only the original thread that created a view hierarchy can touch its views
        因为Android不允许在子线程中更新UI，随意Android提供了一套异步消息处理机制
        我们用Handler机制来进行更新UI的操作
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = UPDATE_TEXT;
                handler.sendMessage(message);
            }
        }).start();
    }
}
