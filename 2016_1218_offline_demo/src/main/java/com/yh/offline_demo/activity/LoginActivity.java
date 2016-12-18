package com.yh.offline_demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yh.offline_demo.R;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText username;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*
        初始化布局文件
         */
        initView();

    }

    private void initView() {
        username = (EditText) findViewById(R.id.et_login_username);
        password = (EditText) findViewById(R.id.et_login_password);
        login = (Button) findViewById(R.id.bt_login_go);

        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.bt_login_go:
                login();
                break;
            default:
                break;
        }
    }

    /*
    登录操作
     */
    private void login() {
        if (username.getText().toString().equals("yanghang") && password.getText().toString().equals("123456")) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "用户名或密码错误！", Toast.LENGTH_SHORT).show();
        }
    }
}
