package booksCatalog.dao;

import booksCatalog.model.Author;

import java.util.List;


public interface AuthorDao {
    void addAuthor(Author author);
    void deleteAuthor(int id);
    Author getAuthor(int id);
    List<Author> getAllAuthors();
}
