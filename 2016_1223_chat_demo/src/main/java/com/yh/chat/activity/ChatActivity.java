package com.yh.chat.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yh.chat.R;
import com.yh.chat.adapter.ChatAdapter;
import com.yh.chat.bean.Message;

import java.util.ArrayList;


public class ChatActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Message> lists=new ArrayList<>();

    private EditText et_chat_text;
    private Button bt_chat_send;
    private RecyclerView rv_chat;

    private ChatAdapter chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        hideBar();
        initView();
    }

    /*
     隐藏标题栏
    */
    private void hideBar() {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
    }

    /*
    初始化布局
     */
    private void initView() {
        et_chat_text = (EditText) findViewById(R.id.et_chat_text);
        bt_chat_send = (Button) findViewById(R.id.bt_chat_send);
        rv_chat = (RecyclerView) findViewById(R.id.rv_chat);

        bt_chat_send.setOnClickListener(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv_chat.setLayoutManager(layoutManager);
        chatAdapter = new ChatAdapter(lists);
        rv_chat.setAdapter(chatAdapter);
    }

    /*
    响应点击事件
     */
    @Override
    public void onClick(View view) {
        double i=0.5;
        double random = Math.random();//利用随机数来定义是发送消息还是接收消息
        String text = et_chat_text.getText().toString();
        if(text.equals("")||text==null){
            Toast.makeText(this,"输入框为空",Toast.LENGTH_SHORT).show();
        }
        else{
            if(random>i){
            /*
            接收消息
             */
                Message message = new Message(1,text);
                lists.add(message);
                chatAdapter.notifyItemInserted(lists.size()-1);//当有新消息时，刷新RecyclerView中的显示
                rv_chat.scrollToPosition(lists.size()-1);//将消息RecyclerView定位到最后一行
                et_chat_text.setText("");//输入文本框置为空

            }else{
            /*
            发送消息
             */
                Message message = new Message(0,text);
                lists.add(message);
                chatAdapter.notifyItemInserted(lists.size()-1);//当有新消息时，刷新RecyclerView中的显示
                rv_chat.scrollToPosition(lists.size()-1);//将消息RecyclerView定位到最后一行
                et_chat_text.setText("");//输入文本框置为空
            }
        }
    }
}
