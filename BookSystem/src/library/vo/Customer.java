package BookSystem.src.library.vo;

import java.util.Arrays;

public class Customer {

    private String id; // 유저 아이디
    private String pwd; // 유저 비밀번호
    private String name; // 유저 이름
    private int borrowCount; // 총 대출 횟수
    private final int MAX_BOOKNUM = 5; // 한 사람당 대출 가능한 책 수
    private Book[] borringBooks = new Book[MAX_BOOKNUM]; // 대출한 책 리스트
    private int size; // 대출 중인 책 수

    // 생성자
    public Customer() {
    }

    public Customer(String id, String pwd, String name, int borrowCount, Book[] borringBooks) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.borrowCount = borrowCount;
        this.borringBooks = borringBooks;
        this.size = 0;
    }

    // getter/setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public void setBorrowCount(int borrowCount) {
        this.borrowCount = borrowCount;
    }

    public int getMAX_BOOKNUM() {
        return MAX_BOOKNUM;
    }

    public Book[] getBorringBooks() {
        return borringBooks;
    }

    public void setBorringBooks(Book[] borringBooks) {
        this.borringBooks = borringBooks;
        this.size = borringBooks.length;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "회원 이름 : " + name + " 대출 중 도서 목록 : " + Arrays.toString(borringBooks) + "]";
    }

}
