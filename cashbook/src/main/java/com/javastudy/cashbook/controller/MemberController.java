package com.javastudy.cashbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.javastudy.cashbook.dto.CashbookMemberDTO;
import com.javastudy.cashbook.service.MemberService;


@Controller
public class MemberController {

    private MemberService memberService;

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @PostMapping("/joinProc")
    public String joinProc(@ModelAttribute CashbookMemberDTO dto) {
        memberService.insert(dto);
        return "/";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
