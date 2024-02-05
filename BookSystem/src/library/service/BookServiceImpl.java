package BookSystem.src.library.service;

import java.util.ArrayList;
import java.util.List;

import BookSystem.src.library.vo.Book;

public class BookServiceImpl implements BookService {
    private List<Book> books = new ArrayList<>();

    @Override
    public Book search(String bookID) {
        return null;
    }

    @Override
    public boolean addBook(Book book) {
        return false;
    }

    @Override
    public boolean update(Book book) {
        return false;
    }

    @Override
    public boolean delete(String bookID) {
        return false;
    }

    @Override
    public int getBookCount() {
        return books.size();
    }

    @Override
    public List<Book> selectAll() {
        return books;
    }

    @Override
    public boolean possibleBorrow(String id) {
        Book book = search(id);
        return book.isAvailable();
    }

}
