package com.javastudy.cashbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javastudy.cashbook.entity.CashbookMemberEntity;

@Repository
public interface CashbookMemberRepository extends JpaRepository<CashbookMemberEntity,String>{
    
}
