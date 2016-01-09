package booksCatalog.service.impl;

import booksCatalog.dao.CountryDao;
import booksCatalog.model.Country;
import booksCatalog.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao countryDao;

    public Country getCountry(int id) {
        return countryDao.getCountry(id);
    }

    public List<Country> getAllCountries() {
        return countryDao.getAllCountries();
    }
}
