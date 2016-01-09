package booksCatalog.service.impl;

import booksCatalog.dao.AuthorDao;
import booksCatalog.model.Author;
import booksCatalog.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service()
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    public void addAuthor(Author author) {
        authorDao.addAuthor(author);
    }

    public void deleteAuthor(int id) {
        authorDao.deleteAuthor(id);
    }

    public Author getAuthor(int id) {
        return authorDao.getAuthor(id);
    }

    public List<Author> getAllAuthors() {
        return authorDao.getAllAuthors();
    }
}
