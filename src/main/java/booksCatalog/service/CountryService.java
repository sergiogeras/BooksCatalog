package booksCatalog.service;


import booksCatalog.model.Country;

import java.util.List;

public interface CountryService {
    Country getCountry(int id);
    List<Country> getAllCountries();
}
