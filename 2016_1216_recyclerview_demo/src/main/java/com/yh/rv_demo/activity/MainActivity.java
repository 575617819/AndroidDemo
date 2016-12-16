package com.yh.rv_demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yh.rv_demo.R;
import com.yh.rv_demo.adapter.FruitAdapter;
import com.yh.rv_demo.bean.Fruit;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ArrayList<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化水果数据
        initFruit();

        RecyclerView recycler_view_main = (RecyclerView) findViewById(R.id.recycler_view_main);

        /*
        纵向滑动RecyclerView
         */
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler_view_main.setLayoutManager(layoutManager);

        FruitAdapter fruitAdapter = new FruitAdapter(fruitList);
        recycler_view_main.setAdapter(fruitAdapter);
    }

    private void initFruit() {
        for (int i = 0; i < 3; i++) {

            Fruit fruit1 = new Fruit();
            fruit1.setProvince("山西");
            fruit1.setName("苹果");
            fruit1.setPrice("5.99/500g");
            fruitList.add(fruit1);

            Fruit fruit2 = new Fruit();
            fruit2.setProvince("海南");
            fruit2.setName("香蕉");
            fruit2.setPrice("2.88/500g");
            fruitList.add(fruit2);

            Fruit fruit3 = new Fruit();
            fruit3.setProvince("新疆");
            fruit3.setName("哈密瓜");
            fruit3.setPrice("8.88/500g");
            fruitList.add(fruit3);

            Fruit fruit4 = new Fruit();
            fruit4.setProvince("湖南");
            fruit4.setName("橘子");
            fruit4.setPrice("3.99/500g");
            fruitList.add(fruit4);

            Fruit fruit5 = new Fruit();
            fruit5.setProvince("山东");
            fruit5.setName("梨");
            fruit5.setPrice("4.50/500g");
            fruitList.add(fruit5);

            Fruit fruit6 = new Fruit();
            fruit6.setProvince("广东");
            fruit6.setName("菠萝");
            fruit6.setPrice("5.00/500g");
            fruitList.add(fruit6);
        }
    }
}
