package BookSystem.src.library.ui;

import java.util.List;
import java.util.Scanner;

import BookSystem.src.library.service.BookServiceImpl;
import BookSystem.src.library.service.CustomerServiceImpl;
import BookSystem.src.library.vo.Book;
import BookSystem.src.library.vo.Customer;

public class LibSystemUI {
    Scanner scanner = new Scanner(System.in);

    BookServiceImpl bs = new BookServiceImpl();
    CustomerServiceImpl cs = new CustomerServiceImpl();

    public LibSystemUI() {
        // System.out.println("**********************************");
        System.out.println("    [Welcome to DIMA library] ");
        // System.out.println("**********************************");
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

        while (true) {
            System.out.printf("%-4s> ", "아이디");
            id = scanner.next();
            if (cs.search(id) == null) {
                break;
            }
            System.out.println("# 이미 존재하는 아이디입니다. 다시 입력해주세요.");
        }

        System.out.printf("%-4s> ", "비밀번호");
        pwd = scanner.next();
        System.out.printf("%-4s> ", "이름");
        name = scanner.next();

        boolean result = cs.insert(new Customer(id, pwd, name, 0, null));

        if (result)
            System.out.println("# 등록이 성공적으로 완료되었습니다.");

    }

    private void deleteCustomer() {
        System.out.println("\n[회원 탈퇴]");
        String id, answer;

        System.out.print("아이디 입력 > ");
        id = scanner.next();
        if (cs.search(id) == null) {
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
        if (result)
            System.out.println("# 탈퇴가 성공적으로 완료되었습니다.");

    }

    private void updateCustomer() {
        System.out.println("\n[회원 정보 수정]");
        String id, pwd, name;
        System.out.print("아이디 입력 > ");
        id = scanner.next();
        if (cs.search(id) == null) {
            System.out.println("# 등록되지 않은 회원입니다. 메인 메뉴로 돌아갑니다.");
            return;
        }

        System.out.print("수정할 비밀번호 > ");
        pwd = scanner.next();
        System.out.print("수정할 이름 > ");
        name = scanner.next();

        Customer c = new Customer(id, pwd, name, 0, null);

        boolean result = cs.update(c);
        if (result)
            System.out.println("# 정보 수정이 성공적으로 완료되었습니다.");

    }

    private void searchCustomer() {
        System.out.println("\n[회원 정보 조회]");
        String id;
        System.out.print("아이디 입력 > ");
        id = scanner.next();
        Customer c = cs.search(id);
        if (c == null) {
            System.out.println("# 등록되지 않은 회원입니다. 메인 메뉴로 돌아갑니다.");
            return;
        }

        System.out.println(c);
        System.out.println("\n# 정보 조회가 성공적으로 완료되었습니다.");

    }

    private void printAllCustomer() {
        System.out.println("\n[전체 회원 정보 조회]");
        List<Customer> c = cs.selectAll();
        if (c.size() == 0) {
            System.out.println("# 등록된 회원이 없습니다. ");
            return;
        }

        for (int i = 0; i < c.size(); i++) {
            System.out.printf("[%03d] ", i + 1);
            System.out.println(c.get(i));
        }
        System.out.printf("%n총 %d명의 회원이 존재합니다.%n", c.size());

    }

    // 도서 서비스

    private void insertBook() {
        System.out.println("\n[도서 등록]");
        String managerNum;
        System.out.print("# 관리자 전용 메뉴입니다. 관리자 번호 입력해주세요 > ");
        managerNum = scanner.next();
        if (!(managerNum.equals(bs.MANAGER_NUM))) {
            System.out.println("# 번호가 일치하지 않습니다. 메인 메뉴로 돌아갑니다.");
            return;
        }

        String bookID, bookName, author, genre;

        while (true) {
            System.out.print("책 아이디 : ");
            bookID = scanner.next();
            if (bs.search(bookID) == null)
                break;
            System.out.println("** 이미 존재하는 책 아이디 입니다. 다시 입력해주세요.");
        }
        scanner.nextLine();
        System.out.print("책 제목 : ");
        bookName = scanner.nextLine();
        System.out.print("책 저자 : ");
        author = scanner.nextLine();
        System.out.print("책 장르 : ");
        genre = scanner.nextLine();

        boolean result = bs.addBook(new Book(bookID, bookName, author, genre));

        if (result)
            System.out.println("# 도서 등록이 성공적으로 완료되었습니다.");

    }

    private void deleteBook() {
        System.out.println("\n[도서 삭제]");
        String managerNum;
        System.out.print("# 관리자 전용 메뉴입니다. 관리자 번호 입력해주세요 > ");
        managerNum = scanner.next();
        if (!(managerNum.equals(bs.MANAGER_NUM))) {
            System.out.println("# 번호가 일치하지 않습니다. 메인 메뉴로 돌아갑니다.");
            return;
        }
        // 존재하지 않는 도서 정보인 경우 메인으로 ..
        String bookID, answer;
        System.out.print("삭제할 책 아이디 : ");
        bookID = scanner.next();
        if (bs.search(bookID) == null) {
            System.out.println("# 입력한 아이디의 책이 존재하지 않습니다. 메인 메뉴로 돌아갑니다.");
            return;
        }
        // 현재 대출 중인 책은 삭제 불가능
        if (!(bs.search(bookID).isAvailable())) { // false인 경우
            System.out.println("# 현재 대출 중인 책입니다. 도서 삭제가 불가능합니다.");
            System.out.println("# 메인 메뉴로 돌아갑니다.");
            return;
        }

        System.out.print("정말 삭제하시겠습니까? (y/n) > ");
        answer = scanner.next();
        if (!(answer.equalsIgnoreCase("Y"))) {
            System.out.println("# 메인 메뉴로 돌아갑니다.");
            return;
        }

        // 삭제
        boolean result = bs.delete(bookID);
        if (result)
            System.out.println("# 해당 도서가 삭제되었습니다.");

    }

    private void updateBook() {
        System.out.println("\n[도서 정보 수정]");
        String managerNum;
        System.out.print("# 관리자 전용 메뉴입니다. 관리자 번호 입력해주세요 > ");
        managerNum = scanner.next();
        if (!(managerNum.equals(bs.MANAGER_NUM))) {
            System.out.println("# 번호가 일치하지 않습니다. 메인 메뉴로 돌아갑니다.");
            return;
        }
        String bookID, author, genre;
        System.out.print("수정할 책 아이디 : ");
        bookID = scanner.next();
        Book book = bs.search(bookID);
        if (book == null) {
            System.out.println("# 입력한 아이디의 책이 존재하지 않습니다. 메인 메뉴로 돌아갑니다.");
            return;
        }
        System.out.println("## [기존 정보]");
        System.out.println(book);
        System.out.println("## [수정할 내용 입력]");
        scanner.nextLine(); // 버퍼 비우기
        System.out.print("책 저자 : ");
        author = scanner.nextLine();
        System.out.print("책 장르 : ");
        genre = scanner.nextLine();

        boolean result = bs.update(new Book(bookID, null, author, genre));

        if (result)
            System.out.println("# 책 정보 수정이 성공적으로 완료되었습니다.");

    }

    private void printAllBook() {
        System.out.println("\n[전체 도서 정보]");
        List<Book> books = bs.selectAll();
        for (int i = 0; i < books.size(); i++) {
            System.out.printf("[%03d]", i + 1);
            System.out.println(books.get(i));
        }
        System.out.printf("%n총 %d권의 책이 존재합니다.%n", books.size());
    }

    private void searchBook() {
        System.out.println("\n[도서 검색]");
        String bookID;
        System.out.print("검색할 책 아이디 : ");
        bookID = scanner.next();
        Book book = bs.search(bookID);
        if (book == null) {
            System.out.println("# 입력한 아이디의 책이 존재하지 않습니다. 메인 메뉴로 돌아갑니다.");
            return;
        }

        System.out.println("# 도서 정보 입니다.");
        System.out.println(book);
        System.out.println();
    }

    private void borrow_book() {
        System.out.println("\n[도서 대출]");
        String id, bookId;
        System.out.print("회원 아이디 입력 : ");
        id = scanner.next();
        // 등록된 회원인지 확인
        Customer customer = cs.search(id);
        if (customer == null) {
            System.out.println("[오류] 등록되지 않은 회원입니다. 메인 메뉴로 돌아갑니다.");
            return;
        }

        // 대출 중인 권수 확인
        try {
            if (customer.getBorrowingBooks().size() == customer.getMAX_BOOKNUM()) {
                System.out.println("# 현재 5권을 대출중입니다. 한 사람당 5권까지 대출할 수 있습니다. ");
                System.out.println("# 메인 메뉴로 돌아갑니다. ");
                return;
            }

        } catch (Exception e) {
        }

        System.out.print("도서 번호 입력 : ");
        bookId = scanner.next();
        // 등록된 책인지 확인
        Book book = bs.search(bookId);
        if (book == null) {
            System.out.println("[오류] 등록되지 않은 책입니다. 메인 메뉴로 돌아갑니다.");
            return;
        }
        // 대출 가능한 책인지 확인
        if (!(bs.search(bookId).isAvailable())) {
            System.out.println("# 대출이 불가능한 책입니다. 메인 메뉴로 돌아갑니다.");
            return;
        }

        // 대출
        System.out.println("\n# 대출 가능한 책입니다. 아래 반납 날짜와 기한을 확인해주세요.");
        book = cs.borrowBook(id, book);
        System.out.println();
        System.out.println(book);
        System.out.println();
        System.out.println("\n# 도서 대출이 성공적으로 완료되었습니다. ");
        System.out.printf("# [%s]님이 현재 대출 중인 책은 총 (%d/5)권입니다.%n", id, cs.customerBorrowCount(id));

    }

    private void return_book() {
        System.out.println("\n[도서 반납]");
        String id, bookId;
        System.out.print("회원 아이디 입력 : ");
        id = scanner.next();
        // 등록된 회원인지 확인
        Customer customer = cs.search(id);
        if (customer == null) {
            System.out.println("[오류] 등록되지 않은 회원입니다. 메인 메뉴로 돌아갑니다.");
            return;
        }

        // 현재 대출 중인 책 목록 출력
        System.out.println("<현재 대출 중인 책 목록>");
        printBooklist(customer.getBorrowingBooks());
        System.out.println("------------------------------------------------------------");
        while (true) {
            System.out.print("도서 번호 입력 : ");
            bookId = scanner.next();
            // 등록된 책인지 확인
            if (cs.isBookidExist(id, bookId))
                break; // true 이면 반복문 탈출
            System.out.println("[오류] 대출 중인 도서 번호가 아닙니다. 정확하게 입력해주세요.");
        }
        // 반납
        boolean result = cs.returnBook(id, bs.search(bookId));
        if (result)
            System.out.println("# 도서 반납이 성공적으로 완료되었습니다.");
    }

    public void printBooklist(List<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            System.out.printf("[%d] ", i + 1);
            System.out.println(books.get(i));
        }

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
        System.out.println("\t6. 도서 등록");
        System.out.println("\t7. 도서 삭제");
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
