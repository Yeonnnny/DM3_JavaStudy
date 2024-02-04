package BookManagementProject.service;

import java.util.ArrayList;

public interface CustomerService {
    /**
     * 회원 검색
     * 
     * @param id
     * @return
     */
    public Customer search(String id);

    /**
     * 회원 가입
     * 
     * @param customer
     * @return
     */
    public boolean insert(Customer customer);

    /**
     * 회원리스트 반환
     */
    public ArrayList<Customer> selectAll();

    /**
     * 회원 정보 수정 (이름, 비밀번호)
     * 
     * @param customer
     * @return
     */
    public boolean update(Customer customer);

    /**
     * 회원 정보 삭제
     * 
     * @param id
     * @return
     */
    public boolean delete(String id);

    /**
     * 책 대출
     * 
     * @param bookid
     * @return
     */
    public boolean borrowBook(String bookid);

    /**
     * 책 반납
     * 
     * @param bookid
     * @return
     */
    public boolean returnBook(String bookid);

    /**
     * 회원 수
     * 
     * @return
     */
    public int getCount();

}
