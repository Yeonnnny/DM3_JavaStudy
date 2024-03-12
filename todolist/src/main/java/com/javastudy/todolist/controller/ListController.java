package com.javastudy.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListController {
    @PostMapping("/create")
    public String create(@RequestParam(name="userName") String userName, Model model ){
        
        model.addAttribute("userName", userName); 
        
        return "list";
    }
}
