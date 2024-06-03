package com.javastudy.cashbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.javastudy.cashbook.dto.CashbookMemberDTO;
import com.javastudy.cashbook.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    /**
     * ajax - 회원가입 시 아이디가 존재하는지 확인하는 요청
     * @param param
     * @return
     */
    @GetMapping("/join/isExistId")
    @ResponseBody
    public boolean getMethodName(@RequestParam(name = "memberId") String memberId) {
        log.info("아이디확인 : "+memberId);
        return memberService.isExist(memberId);
    }
    

    @PostMapping("/joinProc")
    public String joinProc(@ModelAttribute CashbookMemberDTO dto) {
        memberService.insert(dto);
        return "redirect:/";
    }
    
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
