package com.miniproject.stock.entity;

public enum Category {
    ETC("기타"),OUTER("아우터"), TOP("상의"), BOTTOM("하의"), ACC("잡화"), SHOES("신발");
    // 기타("ETC"),아우터("OUTER"), 상의("TOP"), 하의("BOTTOM"), 잡화("ACC"), 신발("SHOES");

    private String category;

    private Category(String category){
        this.category = category;
    }

    public String getCategory(){
        return this.category;
    }

}
