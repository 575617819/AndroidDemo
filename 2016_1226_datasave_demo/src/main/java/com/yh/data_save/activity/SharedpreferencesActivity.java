package com.yh.data_save.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.yh.data_save.R;

public class SharedPreferencesActivity extends Activity implements View.OnClickListener {

    private EditText et_main_name;
    private EditText et_main_username;
    private EditText et_main_password1;
    private EditText et_main_password2;
    private Button bt_main_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedPreferences);

        et_main_name = (EditText) findViewById(R.id.et_main_name);
        et_main_username = (EditText) findViewById(R.id.et_main_username);
        et_main_password1 = (EditText) findViewById(R.id.et_main_password1);
        et_main_password2 = (EditText) findViewById(R.id.et_main_password2);
        bt_main_register = (Button) findViewById(R.id.bt_main_register);

        bt_main_register.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.bt_main_register:
                break;
            default:
                break;
        }
    }
}
