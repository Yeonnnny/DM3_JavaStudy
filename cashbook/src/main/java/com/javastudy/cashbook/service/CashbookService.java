package com.javastudy.cashbook.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javastudy.cashbook.dto.CashbookInfoDTO;
import com.javastudy.cashbook.entity.CashbookInfoEntity;
import com.javastudy.cashbook.entity.CashbookMemberEntity;
import com.javastudy.cashbook.repository.CashbookInfoRepository;
import com.javastudy.cashbook.repository.CashbookMemberRepository;

@Service
public class CashbookService {
    private CashbookMemberRepository cashbookMemberRepository;
    private CashbookInfoRepository cashbookInfoRepository;

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
        }
    }

    /**
     * infoNum에 해당하는 정보 삭제하는 함수
     */
    public Boolean delete(Long infoNum) {
        Optional<CashbookInfoEntity> cashbookInfoEntity = cashbookInfoRepository.findById(infoNum);
        
        if (cashbookInfoEntity.isPresent()) {
            cashbookInfoRepository.deleteById(infoNum);
            return true;
        }

        return false;
    }

    
}
