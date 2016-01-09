package booksCatalog.dao;


import booksCatalog.model.Country;

import java.util.List;

public interface CountryDao {
    Country getCountry(int id);
    List<Country> getAllCountries();
}
