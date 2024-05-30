package com.javastudy.cashbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javastudy.cashbook.dto.CashbookInfoDTO;
import com.javastudy.cashbook.service.CashbookService;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class CashbookController {
    private CashbookService cashbookService;

    @GetMapping("/cashbook")
    public String cashbook() {
        return "cashbook";
    }

    @PostMapping("/cashbook/create")
    public String create(@ModelAttribute CashbookInfoDTO dto) {
        cashbookService.insert(dto);        
        return "redirect:/cashbook";
    }
    
    

    /**
     * ajax - 가계부 정보 DB에서 infoNum에 해당하는 정보 삭제
     * @param memberId
     * @param infoNum
     * @return
     */
    @ResponseBody
    @GetMapping("/cashbook/delete")
    public Boolean delete(@RequestParam(name = "memberId")String memberId, @RequestParam(name = "infoNum") Long infoNum){
        return cashbookService.delete(infoNum);
    }
    
    
}
