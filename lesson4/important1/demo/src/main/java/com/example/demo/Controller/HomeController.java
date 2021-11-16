package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;

@Controller
public class HomeController {

    private MessageListService messageListService;

    //右键 generate constructor
    //todo: 为什么在service中避免使用constructor但是在controller中就用了？
    public HomeController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    //@RequestMapping
    @GetMapping("/home")
    //todo: 为什么这里要添加newMessage
    //todo: Spring的默认行为并没有把newMessage添加到attribute name中
    //todo: test to use ModelAttribute to override
    public String getHomePage(@ModelAttribute("newMessage") MessageForm newMessage, Model model){
        model.addAttribute("greetings", messageListService.getMessages());
        //separate the controller and service.
        //if we need to change how to manage the messages, we only change the service, not
        //the controller
        return "home";
    }

    @PostMapping("/home")
    public String addMessage(@ModelAttribute("newMessage") MessageForm newMessage, Model model){
        messageListService.addMessage(newMessage.getText());
        model.addAttribute("greetings", messageListService.getMessages());
        //?????
        newMessage.setText(null);
        return "home";
    }
}
