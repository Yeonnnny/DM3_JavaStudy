package BookManagementProject.ui;

import java.util.Scanner;

public class BookSystemUI {
    Scanner scanner = new Scanner(System.in);

    BookServiceImpl bookservice = new BookServiceImpl();
    CustomerServiceImpl customerservice = new CustomerServiceImpl();

    public BookSystemUI() {
        System.out.println("****************************************");
        System.out.println(" [DIMA 도서관에 오신 것을 환영합니다.] ");
        System.out.println("****************************************");
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

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
            }

        }

    }

    public void mainMenu() {
        System.out.println("=======[MENU]=======");
        System.out.println("----[회원 관리]----");
        System.out.println("1. 회원 정보 입력");
        System.out.println("2. 회원 정보 삭제");
        System.out.println("3. 회원 정보 수정");
        System.out.println("4. 회원 정보 검색");
        System.out.println("----[도서 관리]----");
        System.out.println("5. 도서 정보 입력");
        System.out.println("6. 도서 정보 삭제");
        System.out.println("7. 도서 정보 수정");
        System.out.println("----[도서서비스]----");
        System.out.println("8. 도서 정보 검색");
        System.out.println("9. 도서 대출");
        System.out.println("10. 도서 반납");
        System.out.println("------[종료]-------");
        System.out.println("0. 프로그램 종료");
        System.out.println("====================");
        System.out.print(" ** 선택> ");
    }

}
