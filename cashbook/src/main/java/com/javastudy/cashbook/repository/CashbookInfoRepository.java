package com.javastudy.cashbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javastudy.cashbook.entity.CashbookInfoEntity;

@Repository
public interface CashbookInfoRepository extends JpaRepository<CashbookInfoEntity,Long>{

}
