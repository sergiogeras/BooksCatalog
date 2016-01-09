package booksCatalog.service.impl;

import booksCatalog.dao.BookDao;
import booksCatalog.model.Book;
import booksCatalog.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    public Book addBook(Book book) {
        bookDao.addBook(book);
        return book;
    }

    public void deleteBook(int id) {
        bookDao.deleteBook(id);
    }

    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }

    public List<Book> getBooksByAuthorId(int id) {
        return bookDao.getBooksByAuthorId(id);
    }
}
