package booksCatalog.dao.impl;


import booksCatalog.dao.AuthorDao;
import booksCatalog.model.Author;
import booksCatalog.model.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@SuppressWarnings("unchecked")
public class AuthorDaoImpl implements AuthorDao{

    @PersistenceContext
    EntityManager entityManager;

    public void addAuthor(Author author) {
        entityManager.persist(author);
    }

    public void deleteAuthor(int id) {
        List<Book> books = entityManager.createQuery("select b from Book b where b.author.id =:id")
                .setParameter("id", id).getResultList();
        for(Book book: books){
            entityManager.createQuery("delete from Book where id=:id")
                    .setParameter("id", book.getId()).executeUpdate();
        }
        entityManager.createQuery("delete from Author where id=:id")
                .setParameter("id", id).executeUpdate();
    }

    public Author getAuthor(int id) {
        return (Author)entityManager.createQuery("select a from Author  a where a.id=:id")
                .setParameter("id", id).getSingleResult();
    }

    public List<Author> getAllAuthors() {
        return entityManager.createQuery("select a from Author a").getResultList();
    }
}
