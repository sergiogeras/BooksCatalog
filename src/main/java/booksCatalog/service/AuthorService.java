package booksCatalog.service;


import booksCatalog.model.Author;

import java.util.List;

public interface AuthorService {
    void addAuthor(Author author);
    void deleteAuthor(int id);
    Author getAuthor(int id);
    List<Author> getAllAuthors();
}
