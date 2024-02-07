package BookSystem.src.library.service;

import java.util.List;

import BookSystem.src.library.vo.Book;

public interface BookService {
    /**
     * 책 id입력받아 책 정보 반환
     * 
     * @param bookID
     * @return 도서객체
     */
    public Book search(String bookID);

    /**
     * 도서 추가
     * 
     * @param book
     * @return
     */
    public boolean addBook(Book book);

    /**
     * 책 정보 중 저자와 장르 수정
     * 
     * @param book
     * @return
     */
    public boolean update(Book book);

    /**
     * 책 정보 삭제
     * 
     * @param bookID
     * @return
     */
    public boolean delete(String bookID);

    /**
     * 현재 존재하는 도서 정보 수 반환
     * 
     * @return 도서 리스트 크기
     */
    public int getBookCount();

    /**
     * 도서 정보 리스트 반환
     * 
     * @return
     */
    public List<Book> selectAll();

     
    
}
