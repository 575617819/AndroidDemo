package com.yh.chat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yh.chat.R;
import com.yh.chat.bean.Message;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/23.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    ArrayList<Message> arrayLists;

    static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout ll_send;
        LinearLayout ll_receiver;
        TextView tv_send_text;
        TextView tv_receiver_text;

        public ViewHolder(View itemView) {
            super(itemView);
            ll_send = (LinearLayout) itemView.findViewById(R.id.ll_send);
            ll_receiver = (LinearLayout) itemView.findViewById(R.id.ll_receiver);
            tv_send_text = (TextView) itemView.findViewById(R.id.tv_send_text);
            tv_receiver_text = (TextView) itemView.findViewById(R.id.tv_receiver_text);
        }
    }

    public ChatAdapter(ArrayList<Message> arrayLists) {
        this.arrayLists = arrayLists;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Message message = arrayLists.get(position);
        if (message.getMessageType() == 1) {
            /*
            接收到的消息
             */
            holder.tv_receiver_text.setText(arrayLists.get(position).getText());
            holder.ll_send.setVisibility(View.GONE);
        } else if (message.getMessageType() == 0) {
            /*
            发送的消息
             */
            holder.tv_send_text.setText(arrayLists.get(position).getText());
            holder.ll_receiver.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return arrayLists.size();
    }
}
