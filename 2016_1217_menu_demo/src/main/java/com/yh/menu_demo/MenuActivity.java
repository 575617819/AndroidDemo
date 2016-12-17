package com.yh.menu_demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.yh.menu_demo.R;


public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meau);
    }

    /*
    初始化菜单布局文件
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);//第二个参数用于指定我们的菜单项将添加到哪一个Menu对象当中
        return true;//此处返回true为显示菜单，返回false不显示菜单
    }

    /*
    菜单子目录的点击事件
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_all:
                Toast.makeText(this, "显示全部交易成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_today:
                Toast.makeText(this, "您今天还没有发生过交易", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_exit:
                finish();
                break;
            default:
                break;
        }
        return true;
    }
}
