package booksCatalog.dao;

import booksCatalog.model.Book;

import java.util.List;


public interface BookDao {
    Book addBook(Book book);
    void deleteBook(int id);
    Book getBookById(int id);
    List<Book> getBooksByAuthorId(int authorId);
}
