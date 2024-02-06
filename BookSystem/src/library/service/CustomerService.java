package BookSystem.src.library.service;

import java.util.List;

import BookSystem.src.library.vo.Book;
import BookSystem.src.library.vo.Customer;

public interface CustomerService {
    /**
     * 회원 아이디를 입력받아 회원 객체를 반환하는 함수
     * 
     * @param id
     * @return
     */
    public Customer search(String id);

    /**
     * 회원 정보가 담긴 회원 객체를 입력받아 List에 회원 정보 저장하는 함수
     * 
     * @param customer
     * @return
     */
    public boolean insert(Customer customer);

    /**
     * 존재하는 모든 회원 객체 리스트 반환하는 함수
     */
    public List<Customer> selectAll();

    /**
     * 변경하고자하는 정보가 담긴 회원 객체를 입력받고
     * 회원 객체 리스트에서 찾아 내용을 수정하는 함수. 수정할 내용은 이름과 비밀번호로 한정함.
     * 
     * @param customer
     * @return
     */
    public boolean update(Customer customer);

    /**
     * 회원 아이디를 입력 받아 회원 객체 리스트에서 회원 정보 삭제하는 함수
     * 
     * @param id
     * @return
     */
    public boolean delete(String id);

    /**
     * 총 회원 수 빈환하는 함수
     * 
     * @return
     */
    public int getCount();

    // +++++++++++++++++ Book과 관련된 함수들++++++++++++++++++++++++

    /**
     * 회원 id와 책 id를 입력 받아 해당 Book의 대출 가능 여부 값을 변경하고, 해당 Customer의 대출 중인 책 리스트에 책 정보를
     * 삽입하는 함수.
     * 그리고 해당 Customer와 Book의 borrowCount를 1씩 증가시켜 줌.
     * 
     * @param id
     * @param bookid
     * @return 대출한 책 객체
     */
    public Book borrowBook(String id, Book book);

    /**
     * 회원 id와 반납할 책의 id를 입력 받아 해당 Book의 대출 가능 여부 값을 변경하고,
     * 해당 Customer의 대출 중인 책 리스트에서 책 id와 일치하는 Book 객체를 제거하는 함수.
     * 
     * @param id
     * @param bookid
     * @return
     */
    public boolean returnBook(String id, String bookid);

    /**
     * 회원 아이디를 입력받아 해당 회원이 현재 대출 중인 책의 수 반환하는 함수
     * 
     * @param id
     * @return
     */
    public int customerBorrowCount(String id);

    /**
     * 회원 아이디를 입력 받아 회원이 대출 중인 책 리스트 반환하는 함수
     * 
     * @param id
     * @return
     */
    public Book[] returnBorrowingBooklist(String id);

    /**
     * 회원 아이디와 책 아이디를 입력 받아 현재 대출 중인 책인지 확인하는 함수
     * 
     * @param id
     * @param bookid
     * @return
     */
    public boolean isBookidExist(String id, String bookid);

}
