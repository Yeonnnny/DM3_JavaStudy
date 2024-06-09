package com.javastudy.cashbook.service;

import java.time.LocalDateTime;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
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


    /**
     * 전달받은 memberId이 작성한 info들 중 
     * 전달받은 날짜에 해당하는 info들의 income/expense 각각의 금액 반환하는 함수
     * @param memberId
     * @param year
     * @param month
     * @param day
     * @return
     */
    public List<Map<String, Object>> getValue(String memberId, int year, int month, int day) {
        // 반환할 결과 담을 List
        List<Map<String, Object>> result = new ArrayList<>();

        // 검색할 날짜
        LocalDateTime todayStart = LocalDate.of(year, month, day).atStartOfDay();
        LocalDateTime todayEnd = LocalDate.of(year, month, day).plusDays(1).atStartOfDay();
        log.info("{} - {} - {}",memberId, todayStart,todayEnd);
        // memberId와 검색 날짜에 해당하는 info들의 type(income/expense)별 총합
        try {
            long income = cashbookInfoRepository.sumAmountByMemberIdAndDateRangeAndTypeIncome(memberId, todayStart, todayEnd)==null?0:cashbookInfoRepository.sumAmountByMemberIdAndDateRangeAndTypeIncome(memberId, todayStart, todayEnd);
            long expense = cashbookInfoRepository.sumAmountByMemberIdAndDateRangeAndTypeExpense(memberId, todayStart, todayEnd)==null?0:cashbookInfoRepository.sumAmountByMemberIdAndDateRangeAndTypeExpense(memberId, todayStart, todayEnd);
            
            // 결과 세팅
            Map<String, Object> data = new HashMap<>();
            data.put("Income", income);
            data.put("Expense", expense);
            result.add(data);

        } catch (Exception e) {
            return null;
        }

        return result;
    }

    
}
