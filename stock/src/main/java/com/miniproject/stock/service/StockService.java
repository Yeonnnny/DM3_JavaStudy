package com.miniproject.stock.service;

import java.util.List;

import com.miniproject.stock.entity.Stock;

public interface StockService {

    /**
     * pid(시퀀스)로 DB에서 물품 레코드 검색해서 반환하는 함수
     * @param pid : 물품번호
     * @return stock : 물품번호에 해당하는 물품
     */
    public Stock search(Long pid);

    /**
     * DB에 물품 등록하는 함수
     * @param stock
     * @return
     */
    public boolean insert(Stock stock);

    /**
     * pname(물품명)으로 DB에서 물품 레코드를 검색해서 반환하는 함수
     * @param pname : 물품명
     * @return stock : 물품명에 해당하는 물품 
     */
    public Stock selectOne(String pname);
    
    /**
     * DB에 존재하는 모든 물품을 리스트로 반환하는 함수
     * @return 모든 물품 정보
     */
    public List<Stock> selectAll();

    /**
     * 물품객체와 변경하고자 하는 수량을 입력받아 물품 정보를 업데이트하는 재고량 수정 함수. 입고 시는 양수로, 출고 시는 음수로 값을 전달받음. 
     * @param stock
     * @param pnum
     * @return
     */
    public boolean updateNum(Long pid, int pnum); // 입고 시 양수, 출고 시 음수 전달
    
    /**
     * 물품객체와 수정하고자 하는 가격을 입력받아 물품 정보를 업데이트하는 가격 수정 함수.
     * @param stock
     * @param price
     * @return
     */
    public boolean updatePrice(Long pid, int price); // 변경할 가격 전달


    /**
     * 물품 객체를 입력받아 해당하는 물품 데이터를 삭제하는 함수
     * @param stock
     * @return
     */
    public boolean delete(Stock stock); 
    public boolean delete(Long pid); 

}
