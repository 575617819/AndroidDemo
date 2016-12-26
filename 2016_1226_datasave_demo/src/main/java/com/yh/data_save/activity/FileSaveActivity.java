package com.yh.data_save.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yh.data_save.R;
import com.yh.data_save.utils.FileUtils;

public class FileSaveActivity extends Activity implements View.OnClickListener {

    private EditText et_main_text;
    private Button bt_main_save;
    private Button bt_main_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        //如果之前有保存的笔记，将其显示出来,并将光标移动到笔记的末尾，方便接着输入
        String article = FileUtils.show(this);
        if (!TextUtils.isEmpty(article)) {
            et_main_text.setText(article);
            et_main_text.setSelection(article.length());
        }
    }

    /*
    初始化布局
     */
    private void initView() {
        et_main_text = (EditText) findViewById(R.id.et_main_text);
        bt_main_save = (Button) findViewById(R.id.bt_main_save);
        bt_main_delete = (Button) findViewById(R.id.bt_main_delete);

        bt_main_save.setOnClickListener(this);
        bt_main_delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String noteText = et_main_text.getText().toString();
        int id = view.getId();
        switch (id) {
            case R.id.bt_main_save:
                if (!TextUtils.isEmpty(noteText)) {
                    FileUtils.save(this, noteText);
                    Toast.makeText(this, "笔记保存成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "请写入内容", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt_main_delete:
                if (!TextUtils.isEmpty(noteText)) {
                    et_main_text.setText("");
                }
                break;
            default:
                break;
        }
    }
}
