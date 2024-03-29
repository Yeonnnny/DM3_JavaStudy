package com.miniproject.stock.ui;

import java.util.List; 
import java.util.Scanner;

import com.miniproject.stock.entity.Category;
import com.miniproject.stock.entity.Stock;
import com.miniproject.stock.service.StockServiceImpl;
import com.miniproject.stock.util.ConnectionManager;

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
                case "0": 
                    System.out.println("## 프로그램을 종료합니다."); 
                    ConnectionManager.close();
                    return; 
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
            System.out.print("카테고리 (OUTER/TOP/BOTTOM/ACC/SHOES) 입력 (Only 대문자) : ");
            categry = scanner.next();
            try {
                c = Category.valueOf(categry);
                break;
            } catch (Exception e) {
                System.out.println("# 존재하지 않는 선택지입니다. 정확하게 입력해주세요");
            }
        }

        Stock stock = new Stock(pname, price, pnum, c);
        boolean result =  service.insert(stock);
        if (result) System.out.println("## 물품 등록이 완료되었습니다.");
    }

    // 물품 한 개 검색
    private void selectOne() {
        System.out.println("\n[물품 검색]");
        long pid;
        String pname,select;
        Stock stock;
        scanner.nextLine(); // 입력 버퍼 비우기
        
        while (true) {
            System.out.print("1.물품번호 2.물품명\n검색수단 선택 > ");
            select = scanner.nextLine();
            
            if (!(select.equals("1") || select.equals("2"))) {
                System.out.println("# 올바르지 않은 번호입니다. 올바르게 입력해주세요.");
                continue;
            }else break;

        } // end while

        switch (select) {
            case "1":
                System.out.print("# 물품번호 입력 : ");
                pid = scanner.nextLong();
                stock = service.search(pid);
                if (stock==null){
                    System.out.printf("# 물품번호 [%d]에 해당하는 물품이 존재하지 않습니다.%n",pid);
                    return;
                }else{
                    System.out.printf("# 물품번호 [%d]에 해당하는 물품의 정보%n",pid);
                    System.out.println(stock);
                    System.out.println();
                }
                break;
            case "2":
                System.out.print("# 물품명 입력 : ");
                pname = scanner.nextLine();
                stock = service.selectOne(pname);
                if (stock==null){
                    System.out.printf("# 물품명 [%s]에 해당하는 물품이 존재하지 않습니다.%n",pname);
                    return;
                }else{
                    System.out.printf("# 물품명 [%s]에 해당하는 물품의 정보%n",pname);
                    System.out.println(stock);
                    System.out.println();
                }
                break;
        } // end switch
    }

    // 전체 물품 검색
    private void selectAll() {
        System.out.println("\n[물품 전체 보기]");
        List<Stock> stockList=null;

        stockList =  service.selectAll();

        if(stockList==null){
            System.out.println("# 등록된 물품이 0개입니다.\n# 메인으로 돌아갑니다.");
            return;
        }

        System.out.printf("# 총 %d개의 물품이 존재합니다.%n",stockList.size());
        System.out.println("=====================================================================================");
        for (Stock stock : stockList) {
            System.err.println(stock);
        }
        System.out.println("=====================================================================================");
    }
    
    // 물품 입고 or 출고
    private void updateStock() {
        System.out.println("\n[물품 입고 / 출고]");
        Long pid;
        String select;
        int pnum;
        boolean result;
        
        System.out.print("물품번호 입력 > ");
        pid = scanner.nextLong();
        Stock stock = service.search(pid);
        if(stock==null){
            System.out.println("# 해당 번호로 등록된 물품이 없습니다.");
            return;
        }
        
        System.out.println("\n현재 물품 상태");
        System.out.println("=====================================================================================");
        System.out.println(stock);
        System.out.println("=====================================================================================\n");
        
        int cur_pnum = stock.getPnum();
        
        while (true) {
            scanner.nextLine();
            System.out.print("1.입고  2.출고 > ");
            select = scanner.nextLine();
            if(!(select.equals("1") || select.equals("2"))){
                System.out.println("# 다시 선택해주세요");
            }else break;
            
        }
        
        switch (select) {
            case "1":
                System.out.print("입고 수량 : ");
                pnum = scanner.nextInt();
                result = service.updateNum(pid, pnum);
                if (result) System.out.printf("# 입고 전 : %d개, 입고 후 : %d개\n# 정상 입고되었습니다.%n",cur_pnum,cur_pnum+pnum);
                break;
            case "2":
                System.out.print("출고 수량 : ");
                pnum = scanner.nextInt();
                result = service.updateNum(pid, pnum*(-1));
                if (result) System.out.printf("# 출고 전 : %d개, 출고 후 : %d개\n# 정상 출고되었습니다.%n",cur_pnum,cur_pnum-pnum);               
                break;
        }
    }
    
    // 물품 가격 변경
    private void updatePrice() {
        System.out.println("\n[물품 가격 변경]");
        Long pid;
        int price;
        boolean result;
        
        System.out.print("물품번호 입력 > ");
        pid = scanner.nextLong();
        Stock stock = service.search(pid);
        if(stock==null){
            System.out.println("# 해당 번호로 등록된 물품이 없습니다.");
            return;
        }
        
        System.out.println("\n현재 물품 상태");
        System.out.println("=====================================================================================");
        System.out.println(stock);
        System.out.println("=====================================================================================\n");
        
        int cur_price = stock.getPrice();
        
        System.out.print("변경할 가격 : ");
        price = scanner.nextInt();
        result = service.updatePrice(pid, price);
        if(result) System.out.printf("# 변경 전 : %,d원, 변경 후 : %,d원\n# 변경 완료되었습니다.%n",cur_price,price);
        
    }
    
    // 물품 삭제
    private void delete() {
        System.out.println("\n[물품 삭제]");
        Long pid;
        String answer ;
        boolean result;

        System.out.print("물품번호 입력 > ");
        pid = scanner.nextLong();
        Stock stock = service.search(pid);
        if(stock==null){
            System.out.println("# 해당 번호로 등록된 물품이 없습니다.");
            return;
        }
        
        System.out.println("\n현재 물품 상태");
        System.out.println("=====================================================================================");
        System.out.println(stock);
        System.out.println("=====================================================================================\n");
        
        while (true) {
            System.out.print("# 정말 삭제하시겠습니까? (y/n) : ");
            answer = scanner.next();
            if (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N")) {
                break;
            }
            System.out.println("# 다시 입력해주세요. ");
        }

        // result = service.delete(stock); // Why?
        result = service.delete(pid);
        if (result) System.out.println("# 삭제가 완료되었습니다. ");
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
