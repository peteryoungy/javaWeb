package com.udacity.jwdnd.c1.review.model;

public class ChatForm {

    private String username;
    private String messageText;
    private String messageType;

    // get needs an instance with nothing
    public ChatForm(){}

    public ChatForm(String username, String messageText, String messageType) {
        this.username = username;
        this.messageText = messageText;
        this.messageType = messageType;
    }

//    public String getUsername(){
//        return new String(username);
//    }
//    //todo: String作为返回值的时候为什么要构建一个new String
//    public String getMessageText(){
//        return new String(messageText);
//    }
//
//    public String getMessageType(){
//        return new String(messageType);
//    }


    public String getUsername() {
        return username;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }


}
