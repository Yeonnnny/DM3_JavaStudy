package BookSystem.src.library.service;

import java.util.List;

import BookSystem.src.library.vo.Book;
import BookSystem.src.library.vo.Customer;

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
    public List<Customer> selectAll();

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
     * 책 id를 입력 받아 book의 대출 여부 값을 변경하고 customer의 대출 중인 책 리스트에 삽입하는 함수이다.   
     *  그리고 customer의 borrowCount, book의 borrowCount 모두 1을 증가시켜줘야 함 
     * @param id
     * @param bookid
     * @return 대출한 책 개체
     */
    public Book borrowBook(String id,String bookid);

    /**
     * 반납할 책의 id를 입력 받아 book의 대출 여부 값을 변경하고  customer의 대출 중인 책 리스트에서 제거하는 함수이다.
     * @param id
     * @param bookid
     * @return
     */
    public boolean returnBook(String id,String bookid);

    /**
     *  총 회원 수 빈환하는 함수 
     * 
     * @return
     */
    public int getCount();

    /**
     * 회원 아이디를 입력받아 회원의 현재 대출중인 책의 권 수 반환하는 함수
     * @param id
     * @return
     */
    public int customerBorrowCount(String id);

    /**
     * 회원 아이디를 입력 받아 회원이 대출 중인 책 리스트 반환하는 함수
     * @param id
     * @return
     */
    public Book[] returnBorrowingBooklist(String id);
    
    /**
     * 회원 아이디와 책 아이디를 입력 받아 회원이 대출중인 책과 동일한 책 아이디가 있는지 확인하는 함수
     * @param id
     * @param bookid
     * @return
     */
    public boolean isBookidExist(String id, String bookid);


}
