package com.yh.customview_demo.customview;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.yh.customview_demo.R;

/**
 * Created by yanghang on 2016/12/17.
 * <p>
 * 来保证程序中所有的标题栏的统一风格，并且都出发响应事件
 */

public class TitleLayout extends LinearLayout implements View.OnClickListener {

    private final ImageButton title_back;
    private final ImageButton title_home;

    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);
        title_back = (ImageButton) findViewById(R.id.ib_title_back);
        title_home = (ImageButton) findViewById(R.id.ib_title_home);

        title_back.setOnClickListener(this);
        title_home.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.ib_title_back:
                Toast.makeText(getContext(), "你点击了back键", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_title_home:
                Toast.makeText(getContext(), "你点击了home键", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
