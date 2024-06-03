package com.javastudy.cashbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StaticsController {
    
    @GetMapping("statics")
    public String staticsMain () {
        return "statics";
    }
    
}
