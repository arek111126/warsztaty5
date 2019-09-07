package pl.coderslab.book.service;

import org.springframework.stereotype.Service;
import pl.coderslab.book.model.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
public class MemoryBookService implements BookService {
    private List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.", "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    @Override
    public List<Book> findAll() {
        return list;
    }

    @Override
    public Book find(Long id) {
        Optional<Book> first = list.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst();

        return first.orElse(null);

    }

    @Override
    public Book update(Book toUpdate, Long id) {
        Book book = find(id);
        if (book != null) {
            book.setTitle(toUpdate.getTitle());
            book.setPublisher(toUpdate.getPublisher());
            book.setIsbn(toUpdate.getIsbn());
            book.setAuthor(toUpdate.getAuthor());
            book.setType(toUpdate.getType());
        }


        return book;
    }

    @Override
    public void delete(Long id) {


        Book book = find(id);
        if (book != null) {
            list.remove(book);
        }
    }

    @Override
    public Book addBook(Book book) {
        Long newId = list.stream()
                .mapToLong(Book::getId)
                .max()
                .orElse(0) + 1;
            book.setId(newId);
            list.add(book);
        return book;
    }


}
