package com.miniproject.stock.ui;

import java.util.Scanner;

import com.miniproject.stock.service.StockServiceImpl;

public class StockUI {
    Scanner scanner = new Scanner(System.in);
    StockServiceImpl service = new StockServiceImpl();
    public StockUI(){
        String answer;
        
        while (true) {
            menu();
            answer = scanner.next();
            
            switch (answer) {
                case "1": insert();break;
                case "2": selectOne();break;
                case "3": selectAll();break;
                case "4": updateStock(); break;
                case "5": updatePrice();break;
                case "6": delete(); break;
                case "0": System.out.println("## 프로그램을 종료합니다."); return; break;
                default: System.out.println("## 올바르지 않은 번호입니다.\n## 번호를 다시 입력해주세요.");break;
                
            }// end switch
            
        } // end while
    }

    // 물품 등록 
    private void insert() {

    }

    // 물품 한 개 검색
    private void selectOne() {
        
    }

    // 전체 물품 검색
    private void selectAll() {
        
    }

    // 물품 입고 or 출고
    private void updateStock() {
        
    }

    // 물품 가격 변경
    private void updatePrice() {
        
    }

    // 물품 삭제
    private void delete() {
        
    }


    /**
     *  재고 관리 시스템 전체 메뉴 
     */
    public void menu() {
        System.out.println(" <재고 관리 프로그램>");
        System.out.println("=====================");
        System.out.println("1. 물품 등록");
        System.out.println("2. 물품 검색 ");
        System.out.println("3. 물품 전체 보기");
        System.out.println("4. 물품 입고 / 출고 ");
        System.out.println("5. 물품 가격 변경");
        System.out.println("6. 물품 삭제");
        System.out.println("0. 프로그램 종료");
        System.out.println("=====================");
        System.out.print("선택 > ");
    }
    
} // end
