package booksCatalog.controller;

import booksCatalog.model.Country;
import booksCatalog.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@Scope("request")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "getCountries", method = RequestMethod.GET)
    public @ResponseBody List<Country> getCountriesList(){
        return countryService.getAllCountries();
    }
}
