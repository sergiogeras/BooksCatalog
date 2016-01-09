package booksCatalog.dao.impl;


import booksCatalog.dao.CountryDao;
import booksCatalog.model.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@SuppressWarnings("unchecked")
public class CountryDaoImpl implements CountryDao {

    @PersistenceContext
    EntityManager entityManager;

    public Country getCountry(int id) {
        return (Country)entityManager.createQuery("select c from Country c where c.id=:id")
                .setParameter("id", id).getSingleResult();
    }

    public List<Country> getAllCountries() {
        return entityManager.createQuery("select c from Country c").getResultList();
    }
}
