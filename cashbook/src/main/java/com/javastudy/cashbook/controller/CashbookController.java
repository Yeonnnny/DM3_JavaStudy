package com.javastudy.cashbook.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javastudy.cashbook.dto.CashbookInfoDTO;
import com.javastudy.cashbook.service.CashbookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CashbookController {
    private final CashbookService cashbookService;

    @GetMapping("myCashbook/main")
    public String cashbook() {
        return "cashbook";
    }

    @PostMapping("myCashbook/create")
    public String create(@ModelAttribute CashbookInfoDTO dto) {
        cashbookService.insert(dto);        
        return "redirect:/myCashbook/main";
    }
    
    
    /**
     * ajax - 가계부 정보 DB에서 memberId에 해당하는 모든 cashbookInfo 반환. 만약 infoNum을 잔달받는 다면, 전달받은 infoNum에 해당하는 cashbookInfo 삭제
     * @param memberId
     * @param infoNum
     * @return
     */
    // @GetMapping("myCashbook/getList")
    // @ResponseBody
    @RequestMapping(value = "/myCashbook/getList", method = RequestMethod.GET)
    public String getList(@RequestParam(name="memberId") String memberId,
                            @RequestParam(name = "infoNum", defaultValue = "") String infoNum, 
                            Model model){
        // 삭제 버튼 클릭 시 infoNum 전달됨
        if (!infoNum.equals("")) {
            cashbookService.delete(infoNum);
        }
        // memberId에 해당하는 CashbookInfoDTO 리스트
        List<CashbookInfoDTO> list = cashbookService.getList(memberId);
        model.addAttribute("list", list);
        
        return "cashbook::#result"; // cashbook => html문서경로(이름)
    }
    
    /**
     * ajax-전달받은 memberId에 해당하는 회원의 수입/지출에 대한 잔액 요청
     * @param memberId
     * @return
     */
    @ResponseBody
    @GetMapping("myCashbook/getBalance")
    public String getBalance(@RequestParam(name="memberId") String memberId) {
        long balance = cashbookService.getBalance(memberId);

        return balance+"";
    }
    
    
}
