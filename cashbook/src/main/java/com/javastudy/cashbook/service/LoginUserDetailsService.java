package com.javastudy.cashbook.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javastudy.cashbook.dto.CashbookMemberDTO;
import com.javastudy.cashbook.dto.LoginUserDetails;
import com.javastudy.cashbook.entity.CashbookMemberEntity;
import com.javastudy.cashbook.repository.CashbookMemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginUserDetailsService implements UserDetailsService{
    private final CashbookMemberRepository cashbookMemberRepository;

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        // customerId 검증 로직 필요 테이블에 접근해서 데이터 가져옴
        // 사용자가 로그린하면 SecurityConfig가 username을 전달함
        CashbookMemberEntity cashbookMemberEntity = cashbookMemberRepository.findById(memberId)
                                                        .orElseThrow(()->{
                                                            throw new UsernameNotFoundException("Error : 존재하지 않는 아이디");
                                                        });
        CashbookMemberDTO cashbookMemberDTO = CashbookMemberDTO.toDTO(cashbookMemberEntity);
        // 반환을 UserDtails로 반환해야 하므로 CustomerDTO를 UserDetails로 바꿔야 함

        return new LoginUserDetails(cashbookMemberDTO);
    }

    
}
