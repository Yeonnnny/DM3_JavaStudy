package com.miniproject.stock.service;

import java.util.List;

import com.miniproject.stock.entity.Stock;

public class StockServiceImpl implements StockService{


    @Override
    public Stock search(int pid) {


        return null;
    }

    @Override
    public boolean insert(Stock product) {
        return false;
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
    public boolean updateStock(int pid, int stock) {
        return false;
    }

    @Override
    public boolean updatePrice(int pid, int price) {
        return false;
    }
    
}
