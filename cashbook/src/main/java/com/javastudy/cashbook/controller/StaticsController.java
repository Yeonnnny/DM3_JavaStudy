package com.javastudy.cashbook.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javastudy.cashbook.service.CashbookService;

import lombok.RequiredArgsConstructor;


// @CrossOrigin(origins = "http://localhost:8090/cashbook")
@Controller
@RequiredArgsConstructor
public class StaticsController {
    private final CashbookService cashbookService;

    @GetMapping("statics")
    public String staticsMain () {
        return "statics";
    }

    /**
     * ajax - 전달받은 year,month,day에 해당하는 CashbookInfo에서 type에 따른 금액 반환
     * @param param
     * @return
     */
    @ResponseBody
    @GetMapping("statics/getValue")
    public List<Map<String,Object>> getValue(
        @RequestParam(name = "memberId") String memberId,
        @RequestParam(name = "year") int year,
        @RequestParam(name = "month") int month,
        @RequestParam(name = "day") int day) {

        // month가 0부터 시작하는 값이기 때문에 1 더해줌
        // month++;

        return cashbookService.getValue(memberId,year,month,day);
    }
    
}
