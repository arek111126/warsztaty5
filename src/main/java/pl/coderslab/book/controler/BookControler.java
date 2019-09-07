package pl.coderslab.book.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.book.model.Book;
import pl.coderslab.book.service.BookService;

import java.util.List;

@RequestMapping("/books")
@RestController
public class BookControler {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getBooks() {

        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.find(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,@RequestBody Book book) {
       return bookService.update(book,id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }



}