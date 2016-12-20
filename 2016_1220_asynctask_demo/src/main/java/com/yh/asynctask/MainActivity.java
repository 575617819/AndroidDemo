package com.yh.asynctask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button bt_main_weather;
    private TextView tv_main_city;
    private TextView tv_main_temp1;
    private TextView tv_main_temp2;
    private TextView tv_main_date;
    private ProgressDialog progressDialog;

    public static int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    /*
    初始化布局
     */
    private void initView() {
        bt_main_weather = (Button) findViewById(R.id.bt_main_weather);
        bt_main_weather.setOnClickListener(this);
        tv_main_city = (TextView) findViewById(R.id.tv_main_city);
        tv_main_temp1 = (TextView) findViewById(R.id.tv_main_temp1);
        tv_main_temp2 = (TextView) findViewById(R.id.tv_main_temp2);
        tv_main_date = (TextView) findViewById(R.id.tv_main_date);
    }

    @Override
    public void onClick(View view) {
        progressDialog = new ProgressDialog(this);
        ShowWeatherTask showWeatherTask = new ShowWeatherTask();
        showWeatherTask.execute();//启动任务
    }

    class ShowWeatherTask extends AsyncTask<Void, Integer, Boolean> {

        /*
        初始化操作
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
        }

        /*
        异步任务
         */
        @Override
        protected Boolean doInBackground(Void... voids) {

            try {
                while (true) {
                    int i = doDownload();
                    publishProgress(i);
                    if (i >= 100) {
                        break;
                    }
                }
            } catch (Exception e) {
                return false;
            }

            return true;
        }

        /*
        更新进度条(更新下载进度)
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            progressDialog.setMessage("已加载" + values[0] + "%");
        }

        /*
        对UI进行操作
         */
        @Override
        protected void onPostExecute(Boolean aBoolean) {
            progressDialog.dismiss();
            if (aBoolean) {
                tv_main_city.setText("城市：山西省临汾市");
                tv_main_temp1.setText("最高气温：30°");
                tv_main_temp2.setText("最低气温：20°");
                tv_main_date.setText("当前时间："+System.currentTimeMillis());

            } else {
                Toast.makeText(MainActivity.this, "天气信息加载失败", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private int doDownload() {
        try {
            Thread.sleep(100);
            x++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return x;
    }

}
