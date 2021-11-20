package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import com.udacity.jwdnd.c1.review.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat") //加了这个之后下面的get，post就不需要再写("/chat)了
public class ChatController {
    //@Autowired
    private MessageService messageService;

    // why getChat form?
    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String getMapping(@ModelAttribute("newMessage") ChatForm chatForm, Model model){

        model.addAttribute("chatMessages",messageService.getChatMessage());
        return "chat";
    }

    //todo: Controller不可以直接调用bean吗？

    @PostMapping
    public String postMapping(@ModelAttribute("newMessage") ChatForm chatForm,
                              Authentication authentication, Model model){
        // note: use Spring Security to fetch the username of the current user
        chatForm.setUsername(authentication.getName());
        messageService.addMessage(chatForm);
        //todo: 别忘了清空text框，这点其实很重要！
        chatForm.setMessageText("");

        model.addAttribute("chatMessages",messageService.getChatMessage());

        return "chat";
    }

    @ModelAttribute("chatMessages")
    public ChatMessage getChatMessage(){
        return new ChatMessage();
    }
}
