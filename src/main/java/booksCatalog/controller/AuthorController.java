package booksCatalog.controller;

import booksCatalog.model.Author;
import booksCatalog.model.Country;
import booksCatalog.service.AuthorService;
import booksCatalog.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Scope("session")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CountryService countryService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex(){
        return "index";
    }

    @RequestMapping(value = "/deleteAuthor", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteAuthor(@RequestParam("authorId") int authorId){
        authorService.deleteAuthor(authorId);
    }

    @RequestMapping(value = "/getAuthorsList", method = RequestMethod.GET)
    public @ResponseBody List<Author> showAllAuthors(){
        return authorService.getAllAuthors();
    }

    @RequestMapping(value = "/addAuthor", method = RequestMethod.GET)
    public @ResponseBody List<Author> addAuthor(@RequestParam("name") String name,
                                                @RequestParam("countryId") int countryId){
        Country country = countryService.getCountry(countryId);
        Author author = new Author(name, country);
        authorService.addAuthor(author);
        return  authorService.getAllAuthors();
    }
}
