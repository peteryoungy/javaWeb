package com.example.demo.Controller;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageListService {

    private List<String> messages;

    @PostConstruct
    //替代constructor, 但这时候要有返回值
    public void PostConstruct(){
        this.messages = new ArrayList<>();
    }

    public List<String> getMessages(){
        //why create a new arraylist?
        return new ArrayList<>(messages);
    }

    public void addMessage(String message){
        messages.add(message);
    }
}
