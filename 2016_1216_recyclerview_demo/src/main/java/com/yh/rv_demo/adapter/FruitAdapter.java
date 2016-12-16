package com.yh.rv_demo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yh.rv_demo.R;
import com.yh.rv_demo.bean.Fruit;

import java.util.ArrayList;

/**
 * Created by yanghang on 2016/12/16.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private ArrayList<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView fruitProvince;
        TextView fruitName;
        TextView fruitPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            fruitProvince = (TextView) itemView.findViewById(R.id.tv_fruit_province);
            fruitName = (TextView) itemView.findViewById(R.id.tv_fruit_name);
            fruitPrice = (TextView) itemView.findViewById(R.id.tv_fruit_price);
        }
    }

    public FruitAdapter(ArrayList<Fruit> fruitList) {
        mFruitList = fruitList;
    }

    /*
    onCreateViewHolder用于创建ViewHolder实例
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    /*
    onBindViewHolder对RecyclerView子项进行赋值，会在每个子项被滚动到屏幕内部时执行
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitProvince.setText(fruit.getProvince());
        holder.fruitName.setText(fruit.getName());
        holder.fruitPrice.setText(fruit.getPrice());
    }

    /*
    getItemCount获取RecyclerView共有多少项
     */
    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
}
