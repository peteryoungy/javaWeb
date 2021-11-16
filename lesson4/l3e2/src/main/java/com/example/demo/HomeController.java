package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/animal")  //todo: 写在这里?
public class HomeController {
    private MessageListService messageListService;

    public HomeController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping("/animal")
    public String getMethod(@ModelAttribute("messageForm") MessageForm messageForm, Model model) {
        model.addAttribute("greetings", messageListService.getMessages());
        return "animal";
    }

    @PostMapping("/animal")
    public String postMethod(@ModelAttribute("messageForm") MessageForm messageForm, Model model) {
        messageListService.addMessage(messageForm.getAnimalName());
        messageListService.addMessage(messageForm.getAdjective());
        model.addAttribute("greetings", messageListService.getMessages());
        messageForm.setAdjective("");
        messageForm.setAnimalName("");
        return "animal";
    }
}