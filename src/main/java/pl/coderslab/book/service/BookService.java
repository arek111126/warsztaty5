package pl.coderslab.book.service;

import pl.coderslab.book.model.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book find(Long id);

    Book update(Book toUpdate,Long id);

    void delete(Long id);
    Book addBook(Book book);
}
