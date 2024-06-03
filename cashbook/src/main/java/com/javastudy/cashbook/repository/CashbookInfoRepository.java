package com.javastudy.cashbook.repository;

import java.util.List;

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
}
