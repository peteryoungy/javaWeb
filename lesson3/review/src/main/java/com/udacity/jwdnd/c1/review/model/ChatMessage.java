package com.udacity.jwdnd.c1.review.model;

import org.springframework.stereotype.Repository;

@Repository
public class ChatMessage {

    //att: 为什么这里一定要是public的？
    public String messageId;
    public String username;
    public String messageText;

    public ChatMessage(){}

    public ChatMessage(String username, String messageText) {
        this.username = username;
        this.messageText = messageText;
    }

    public ChatMessage(String messageId, String username, String messageText) {
        this.messageId = messageId;
        this.username = username;
        this.messageText = messageText;
    }
}
