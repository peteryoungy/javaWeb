package com.example.demo.Controller;

public class MessageForm {

    private String text;  // match th:field

    public String getText(){
        //String is immutable
        return text;
    }

    public void setText(String text){
        this.text = text;
    }
}
