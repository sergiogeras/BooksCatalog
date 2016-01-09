package booksCatalog.controller;

import booksCatalog.model.Author;
import booksCatalog.model.Book;
import booksCatalog.service.AuthorService;
import booksCatalog.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@Scope("session")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;


    @RequestMapping(value = "getBooks", method = RequestMethod.GET)
    public @ResponseBody List<Book> getBooksByAuthor(@RequestParam("authorId") int authorId){
        return bookService.getBooksByAuthorId(authorId);
    }

    @RequestMapping(value = "deleteBook", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteBook(@RequestParam("bookId") int bookId) {
        bookService.deleteBook(bookId);
    }

    @RequestMapping(value = "addBook", method = RequestMethod.GET)
    public @ResponseBody Book addBook(@RequestParam("name") String name,
                                            @RequestParam("genre") String genre,
                                            @RequestParam("authorId") int authorId){
        Author author = authorService.getAuthor(authorId);
        Book book = new Book(name, genre, author);
        return bookService.addBook(book);
    }

}
