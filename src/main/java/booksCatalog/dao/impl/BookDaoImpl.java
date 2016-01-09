package booksCatalog.dao.impl;


import booksCatalog.dao.BookDao;
import booksCatalog.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
@SuppressWarnings("unchecked")
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    EntityManager entityManager;

    public Book addBook(Book book) {
        entityManager.persist(book);
        return book;
    }

    public void deleteBook(int id) {
        entityManager.createQuery("delete from Book b where b.id=:id").setParameter("id", id).executeUpdate();

    }

    public Book getBookById(int id) {
        return (Book)entityManager.createQuery("select b from Book b").getSingleResult();
    }

    public List<Book> getBooksByAuthorId(int authorId) {
        Query query = entityManager.createQuery("select b from Book b where b.author.id=:authorId ")
                .setParameter("authorId", authorId);
        return query.getResultList();
    }
}
