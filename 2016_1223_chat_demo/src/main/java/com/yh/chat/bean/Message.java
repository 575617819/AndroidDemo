package com.yh.chat.bean;

/**
 * Created by yanghang on 2016/12/23.
 */

public class Message {

    private int MESSAGE_SEND = 0;
    private int MESSAGE_RECEIVER = 1;
    private int messageType;
    private String text;

    public Message(int messageType, String text) {
        this.messageType = messageType;
        this.text = text;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
