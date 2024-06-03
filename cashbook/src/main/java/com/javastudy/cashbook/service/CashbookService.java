package com.javastudy.cashbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javastudy.cashbook.dto.CashbookInfoDTO;
import com.javastudy.cashbook.entity.CashbookInfoEntity;
import com.javastudy.cashbook.entity.CashbookMemberEntity;
import com.javastudy.cashbook.repository.CashbookInfoRepository;
import com.javastudy.cashbook.repository.CashbookMemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CashbookService {
    private final CashbookMemberRepository cashbookMemberRepository;
    private final CashbookInfoRepository cashbookInfoRepository;

    /**
     * 전달받은 데이터를 cashbookInfo DB에 저장
     * @param dto
     */
    public void insert(CashbookInfoDTO dto) {
        Optional<CashbookMemberEntity> cashbookMemberEntity = cashbookMemberRepository.findById(dto.getMemberId());
        
        if (cashbookMemberEntity.isPresent()) {
            CashbookMemberEntity memberEntity = cashbookMemberEntity.get();
            CashbookInfoEntity entity = CashbookInfoEntity.toEntity(dto, memberEntity);

            cashbookInfoRepository.save(entity);
            log.info("===== cashbook 저장 완료 =====");
        }
    }

    /**
     * infoNum에 해당하는 정보 삭제하는 함수
     */
    public Boolean delete(String infoNum) {
        Long num = Long.parseLong(infoNum);
        Optional<CashbookInfoEntity> cashbookInfoEntity = cashbookInfoRepository.findById(num);
        
        if (cashbookInfoEntity.isPresent()) {
            cashbookInfoRepository.deleteById(num);
            return true;
        }

        return false;
    }

    /**
     * memberId에 해당하는 cashbookInfoDTO리스트 반환하는 함수
     * @param memberId
     * @return
     */
    public List<CashbookInfoDTO> getList(String memberId) {
        List<CashbookInfoEntity> entities = cashbookInfoRepository.findByMemberId(memberId);
        List<CashbookInfoDTO> dtos = new ArrayList<>();

        entities.forEach((entity)->{
            dtos.add(CashbookInfoDTO.toDTO(entity, memberId));
        });

        return dtos;
    }


    /**
     * 전달받은 memberId에 해당하는 cashbookInfo의 잔액 반환하는 함수
     * @param memberId
     * @return
     */
    public long getBalance(String memberId) {
        long balance = 0;
        List<CashbookInfoEntity> entities = cashbookInfoRepository.findByMemberId(memberId);
        if (entities.size()>0) {
            balance = cashbookInfoRepository.getTotalAmountByMemberId(memberId); 
        }
        return balance;
    }

    
}
