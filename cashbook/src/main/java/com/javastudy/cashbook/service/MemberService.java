package com.javastudy.cashbook.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.javastudy.cashbook.dto.CashbookMemberDTO;
import com.javastudy.cashbook.entity.CashbookMemberEntity;
import com.javastudy.cashbook.repository.CashbookMemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final CashbookMemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 전달받은 memberDTO DB에 저장
     * @param dto
     */
    public void insert(CashbookMemberDTO dto) {
        
        if (!memberRepository.existsById(dto.getMemberId())) {
            // 기본값 세팅
            dto.setEnabled(true);
            dto.setRolename("ROLE_USER");
            dto.setMemberPw(bCryptPasswordEncoder.encode(dto.getMemberPw()));
            // DB에 저장
            memberRepository.save(CashbookMemberEntity.toEntity(dto));
            log.info("회원가입 service - DB 저장 완료");
        }
    }

    /**
     * 전달받은 memberId에 해당하는 회원정보가 존재하는지 확인하는 함수. 존재하는 경우 true, 존재하지 않는 경우 false
     * @param memberId
     * @return
     */
    public boolean isExist(String memberId) {
        return memberRepository.existsById(memberId);
    }
}
