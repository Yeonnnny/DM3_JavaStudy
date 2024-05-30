package com.javastudy.cashbook.service;

import org.springframework.stereotype.Service;

import com.javastudy.cashbook.dto.CashbookMemberDTO;
import com.javastudy.cashbook.entity.CashbookMemberEntity;
import com.javastudy.cashbook.repository.CashbookMemberRepository;

@Service
public class MemberService {
    private CashbookMemberRepository memberRepository;

    /**
     * 전달받은 memberDTO DB에 저장
     * @param dto
     */
    public void insert(CashbookMemberDTO dto) {
        if (!memberRepository.existsById(dto.getMemberId())) {
            memberRepository.save(CashbookMemberEntity.toEntity(dto));
        }
    }
}
