package BookSystem.src.library.ui;

import java.util.List;
import java.util.Scanner;

import BookSystem.src.library.service.BookServiceImpl;
import BookSystem.src.library.service.CustomerServiceImpl;
import BookSystem.src.library.vo.Customer;

public class LibSystemUI {
    Scanner scanner = new Scanner(System.in);

    BookServiceImpl bs = new BookServiceImpl();
    CustomerServiceImpl cs = new CustomerServiceImpl();

    public LibSystemUI() {
        System.out.println("**********************************");
        System.out.println("    [Welcome to DIMA library] ");
        System.out.println("**********************************");
        int mainMenu = -1;

        while (true) {
            try {
                mainMenu();
                mainMenu = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("[오류] 다시 선택하세요");
                scanner.nextLine();
                continue;
            }

            switch (mainMenu) {
                case 1: 
                    insertCustomer();
                    break;
                case 2:
                    deleteCustomer();
                    break;
                case 3:
                    updateCustomer();
                    break;
                case 4:
                    searchCustomer();
                    break;
                case 5:
                    printAllCustomer();
                    break;
                case 6:
                    insertBook();
                    break;
                case 7:
                    deleteBook();
                    break;
                case 8:
                    updateBook();
                    break;
                case 9:
                    printAllBook();
                    break;
                case 10:
                    searchBook();
                    break;
                case 11:
                    borrow_book();
                    break;
                case 12:
                    return_book();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
            }

        }

    }

    
    // 회원 서비스

    private void insertCustomer() {
        System.out.println("\n[회원 등록]");
        
        String id, pwd, name;
        
        while(true){
            System.out.printf("%-4s> ","아이디");
            id = scanner.next();
            if (cs.search(id)==null){
                break;
            }
            System.out.println("# 이미 존재하는 아이디입니다. 다시 입력해주세요.");
        }
        

        System.out.printf("%-4s> ","비밀번호");
        pwd = scanner.next();
        System.out.printf("%-4s> ","이름");
        name = scanner.next();
        
        boolean result = cs.insert(new Customer(id, pwd, name, 0, null));
        
        if(result) System.out.println("# 등록이 성공적으로 완료되었습니다.");
        
    }
    private void deleteCustomer() {
        System.out.println("\n[회원 탈퇴]");
        String id, answer ;

        System.out.print("아이디 입력 > ");
        id = scanner.next();
        if (cs.search(id)==null) {
            System.out.println("# 등록되지 않은 회원입니다. 메인 메뉴로 돌아갑니다.");
            return;
        }
        System.out.print("정말 탈퇴하시겠습니까? (y/n) > ");
        answer = scanner.next();
        if (!(answer.equalsIgnoreCase("Y"))) {
            System.out.println("# 메인 메뉴로 돌아갑니다.");
            return;
        }

        boolean result = cs.delete(id);
        if(result) System.out.println("# 탈퇴가 성공적으로 완료되었습니다.");
        
    }
    
    private void updateCustomer() {
        System.out.println("\n[회원 정보 수정]");
        String id,pwd,name;
        System.out.print("아이디 입력 > ");
        id = scanner.next();
        if (cs.search(id)==null) {
            System.out.println("# 등록되지 않은 회원입니다. 메인 메뉴로 돌아갑니다.");
            return;
        }
        
        System.out.print("수정할 비밀번호 > ");
        pwd = scanner.next();
        System.out.print("수정할 이름 > ");
        name = scanner.next();
        
        Customer c = new Customer(id, pwd, name, 0, null);
        
        boolean result = cs.update(c);
        if (result) System.out.println("# 정보 수정이 성공적으로 완료되었습니다.");
        
    }
    
    private void searchCustomer() {
        System.out.println("\n[회원 정보 조회]");
        String id;
        System.out.print("아이디 입력 > ");
        id = scanner.next();
        Customer c = cs.search(id);
        if (c==null) {
            System.out.println("# 등록되지 않은 회원입니다. 메인 메뉴로 돌아갑니다.");
            return;
        }

        System.out.println(c);
        System.out.println("\n# 정보 조회가 성공적으로 완료되었습니다.");
        
    }

    private void printAllCustomer() {
        System.out.println("[전체 회원 정보 조회]");
        List<Customer> c = cs.selectAll();
        for (int i=0;i<c.size();i++) {
            System.out.printf("[%03d] ",i);
            System.out.println(c.get(i));
        }
    }

    // 도서 서비스
    private void insertBook() {
        
    }
    private void deleteBook() {
        
    }
    private void updateBook() {
        
    }
    private void printAllBook() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printAllBook'");
    }
    private void searchBook() {
        
    }
    
    private void borrow_book() {

    }
    
    private void return_book() {

    }

    
    
    
    public void mainMenu() {
        System.out.println("\n=============[MENU]==============");
        System.out.println("\n-----------[회원 관리]-----------");
        System.out.println("\t1. 회원 정보 입력");
        System.out.println("\t2. 회원 정보 삭제");
        System.out.println("\t3. 회원 정보 수정");
        System.out.println("\t4. 회원 정보 검색");
        System.out.println("\t5. 전체 회원 정보");
        System.out.println("\n-----------[도서 관리]-----------");
        System.out.println("\t6. 도서 정보 입력");
        System.out.println("\t7. 도서 정보 삭제");
        System.out.println("\t8. 도서 정보 수정");
        System.out.println("\n-----------[도서서비스]-----------");
        System.out.println("\t9. 전체 도서 정보");
        System.out.println("\t10. 도서 정보 검색");
        System.out.println("\t11. 도서 대출");
        System.out.println("\t12. 도서 반납");
        System.out.println("\n-------------[종료]--------------");
        System.out.println("\t0. 프로그램 종료");
        System.out.println("\n==================================");
        System.out.print(" ** 선택> ");
    }

}
