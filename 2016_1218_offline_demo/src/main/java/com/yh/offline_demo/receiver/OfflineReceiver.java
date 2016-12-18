package com.yh.offline_demo.receiver;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import com.yh.offline_demo.activity.LoginActivity;
import com.yh.offline_demo.utils.ActivityCollector;

/**
 * Created by yanghang on 2016/12/18.
 */

public class OfflineReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {

        /*
        弹出强制下线对话框
         */
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("警告");
        builder.setMessage("您的账号在另一台设备上登录，请尝试重新登录");
        builder.setCancelable(false);//将对话框设为不可取消
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ActivityCollector.removeAllActivity();
                Intent intent = new Intent(context, LoginActivity.class);
                context.startActivity(intent);
            }
        });
        builder.show();
    }
}
