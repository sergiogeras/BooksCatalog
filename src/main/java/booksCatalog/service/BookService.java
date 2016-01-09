package booksCatalog.service;


import booksCatalog.model.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);
    void deleteBook(int id);
    Book getBookById(int id);
    List<Book> getBooksByAuthorId(int id);
}
