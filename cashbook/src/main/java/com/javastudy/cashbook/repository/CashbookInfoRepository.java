package com.javastudy.cashbook.repository;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javastudy.cashbook.entity.CashbookInfoEntity;

@Repository
public interface CashbookInfoRepository extends JpaRepository<CashbookInfoEntity,Long>{
    
    // memberId에 해당하는 모든 cashbookInfo를 등록일 순으로 반환
    @Query("SELECT c FROM CashbookInfoEntity c WHERE c.cashbookMemberEntity.memberId = :memberId ORDER BY c.inputDate")
    List<CashbookInfoEntity> findByMemberId(@Param("memberId") String memberId);

    // memberId에 해당하는 회원의 type에 따른 amount 총합(income(+)/expense(-))
    @Query("SELECT SUM(CASE WHEN c.type = 'income' THEN c.amount WHEN c.type = 'expense' THEN -c.amount ELSE 0 END) FROM CashbookInfoEntity c WHERE c.cashbookMemberEntity.memberId = :memberId")
    Long getTotalAmountByMemberId(@Param("memberId") String memberId);
    
    //memberId에 해당하고, inputDate가 전달된 날짜 사이에 해당하고, type이 income인 데이터들의 amount 합
    @Query("SELECT SUM(c.amount) FROM CashbookInfoEntity c WHERE c.cashbookMemberEntity.memberId = :memberId AND c.inputDate BETWEEN :todayStart AND :todayEnd AND c.type = 'income'")
    Long sumAmountByMemberIdAndDateRangeAndTypeIncome(@Param("memberId") String memberId, @Param("todayStart") LocalDateTime todayStart, @Param("todayEnd") LocalDateTime todayEnd);
    
    //memberId에 해당하고, inputDate가 전달된 날짜 사이에 해당하고, type이 expense 데이터들의 amount 합
    @Query("SELECT SUM(c.amount) FROM CashbookInfoEntity c WHERE c.cashbookMemberEntity.memberId = :memberId AND c.inputDate BETWEEN :todayStart AND :todayEnd AND c.type = 'expense'")
    Long sumAmountByMemberIdAndDateRangeAndTypeExpense(@Param("memberId") String memberId, @Param("todayStart") LocalDateTime todayStart, @Param("todayEnd") LocalDateTime todayEnd);
}