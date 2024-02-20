package com.miniproject.stock.service;

import java.util.List;
   
import com.miniproject.stock.entity.Stock;
import com.miniproject.stock.util.ConnectionManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class StockServiceImpl implements StockService{


    @Override
    public Stock search(int pid) {
        
        return null;
    }

    @Override
    public boolean insert(Stock stock) {
        boolean result = false;
        EntityManager manager = ConnectionManager.getManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            manager.persist(stock);
            tx.commit();
            result = true;
        } catch (Exception e) {
            tx.rollback();
        }finally{
            manager.close();
        }
        return result;
    }

    @Override
    public Stock selectOne(int pid) {
        
        return null;
    }

    @Override
    public List<Stock> selectAll(){
        return null;
    }

    @Override
    public boolean updateStock(int pid, int num) {
        return false;
    }

    @Override
    public boolean updatePrice(int pid, int price) {




        return false;
    }
    
}
