package com.miniproject.stock.service;

import java.util.List;
   
import com.miniproject.stock.entity.Stock;
import com.miniproject.stock.util.ConnectionManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class StockServiceImpl implements StockService{


    @Override
    public Stock search(long pid) {
        Stock stock =null;
        EntityManager manager = ConnectionManager.getManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            stock = manager.find(Stock.class, pid);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally{
            manager.close();
        }
        return stock;
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
    public Stock selectOne(String pname) {
        
        return null;
    }

    @Override
    public List<Stock> selectAll(){
        return null;
    }

    @Override
    public boolean updateStock(long pid, int num) {
        return false;
    }

    @Override
    public boolean updatePrice(long pid, int price) {




        return false;
    }
    
}
