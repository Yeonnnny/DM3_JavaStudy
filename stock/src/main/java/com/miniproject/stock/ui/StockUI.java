package com.miniproject.stock.ui;

import java.util.Scanner;

import com.miniproject.stock.entity.Category;
import com.miniproject.stock.entity.Stock;
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
        System.out.println("\n[물품 등록]");
        String pname, categry;
        int price, pnum;
        Category c;

        scanner.nextLine();
        System.out.print("물품명 : ");
        pname = scanner.nextLine();
        System.out.print("물품 가격 : ");
        price = scanner.nextInt();
        System.out.print("물품 개수 : ");
        pnum = scanner.nextInt();
        scanner.nextLine();
        while (true) {
            System.out.print("카테고리(OUTER/TOP/BOTTOM/ACC/SHOES) 입력:");
            categry = scanner.nextLine();
            try {
                c = Category.valueOf(categry);
                break;
            } catch (Exception e) {
                System.out.println("존재하지 않는 선택지입니다. 다시 입력해주세요");
                scanner.nextLine();
            }
        }

        Stock stock = new Stock(pname, price, pnum, c);

        boolean result =  service.insert(stock);
        if (result) System.out.println("## 물품 등록이 완료되었습니다.");
    }

    // 물품 한 개 검색
    private void selectOne() {
        System.out.println("\n[물품 검색]");
        String pname;
        System.out.print("물품명 입력 :");
        
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
