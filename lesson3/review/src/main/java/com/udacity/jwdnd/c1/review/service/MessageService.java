package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.mapper.MessageMapper;
import com.udacity.jwdnd.c1.review.mapper.UserMapper;
import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
//@MapperScan("com.udacity,jwdnd.c1.review.com.udacity.jwdnd.c1.review.Mapper.MessageMapper")
public class MessageService {

    private MessageMapper messageMapper;

//    public MessageService(MessageMapper messageMapper) {
//        this.messageMapper = messageMapper;
//    }
//
//    public MessageService(){}

//    @PostConstruct
//    public void postConstruct(MessageMapper messageMapper) {
//        //this.messageMapper = messageMapper;
//        System.out.println("Creating MessageService bean");
//    }
    public MessageService(MessageMapper messageMapper) {
    this.messageMapper = messageMapper;
}

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService bean");
    }
    //todo:给了constructor是不是还要再提供一个没有任何参数的constructor?


    //todo: 把所有的business logic 放到service中
    // 但此时我们必须接收一个ChatForm 但是最后存的时候是ChatMessage
    public void addMessage(ChatForm chatForm){
        // note: good idea to put the data process affair in the service, this is
        //  where business logic
        String messageText = chatForm.getMessageText();

        if(chatForm.getMessageType().equals("Whisper")){
            //System.out.println("executing whisper");
            messageText = messageText.toLowerCase();
            //messageText = lowercase(messageText);

        }
        if(chatForm.getMessageType().equals("Shout")){
            //System.out.println("executing shout");
            messageText = messageText.toUpperCase();
            //messageText = uppercase(messageText);

        }

        //System.out.println(messageText);
        //chatMessageList.add(new ChatMessage(chatForm.getUsername(),messageText));
        messageMapper.insert(new ChatMessage(chatForm.getUsername(),messageText) );
    }

    // att: how to return a list if there's many results in the SQL?
    //  when there's multiple results, we directly return List in the mapper
    public List<ChatMessage> getChatMessage(){

        return messageMapper.getAllMessages();
    }


    //    public MessageService(String message){
//        System.out.println("@Service MessageService has been created");
//        this.message = message;
//    }
//

    // todo: 所以我在service里面实现是可以的
    public String uppercase(String message){

        return message.toUpperCase();
    }

    public String lowercase(String message){

        return message.toLowerCase();
    }
}


//@Service
//public class MessageService {
//
//    private MessageMapper messageMapper;
//
//    public MessageService(MessageMapper messageMapper) {
//        this.messageMapper = messageMapper;
//    }
//
//    @PostConstruct
//    public void postConstruct() {
//        System.out.println("Creating MessageService bean");
//    }
//
//    public void addMessage(ChatForm chatForm) {
//        ChatMessage newMessage = new ChatMessage();
//        newMessage.setUsername(chatForm.getUsername());
//        switch (chatForm.getMessageType()) {
//            case "Say":
//                newMessage.setMessageText(chatForm.getMessageText());
//                break;
//            case "Shout":
//                newMessage.setMessageText(chatForm.getMessageText().toUpperCase());
//                break;
//            case "Whisper":
//                newMessage.setMessageText(chatForm.getMessageText().toLowerCase());
//                break;
//        }
//        messageMapper.addMessage(newMessage);
//    }
//
//    public List<ChatMessage> getChatMessages() {
//        return messageMapper.getAllMessages();
//    }
//}