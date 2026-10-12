package org.example.webui.week06_assignment.service;

import org.example.webui.week06_assignment.domain.Book;
import org.example.webui.week06_assignment.dto.*;
import org.example.webui.week06_assignment.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repository;
    public BookService(BookRepository repository) { this.repository = repository; }

    public BookResponse create(BookRequest request) {
        Book book = new Book(null, request.title(), request.author(), request.price(), request.category(), request.isbn());
        Book savedBook = repository.save(book);
        return new BookResponse(savedBook.getId(), savedBook.getTitle(), savedBook.getAuthor(),
                savedBook.getPrice(), savedBook.getCategory(), savedBook.getIsbn());
    }
    public List<BookResponse> findAll() {
        return repository.findAll().stream().map(book ->
                new BookResponse(book.getId(), book.getTitle(), book.getAuthor(), book.getPrice(), book.getCategory(), book.getIsbn())).toList();
    }

    public BookResponse findById(Long id) {
        Book book = repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Not found"));

        return new BookResponse(book.getId(), book.getTitle(), book.getAuthor(),
                book.getPrice(), book.getCategory(), book.getIsbn()
        );
    }
    public BookResponse update(Long id, BookRequest request) {
        Book book = repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));

        book.setTitle(request.title());
        book.setAuthor(request.author());
        book.setPrice(request.price());
        book.setCategory(request.category());
        book.setIsbn(request.isbn());

        Book updatedBook = repository.update(book);

        return new BookResponse(updatedBook.getId(), updatedBook.getTitle(), updatedBook.getAuthor(),
                updatedBook.getPrice(), updatedBook.getCategory(), updatedBook.getIsbn());
    }


    public void delete(Long id) {
        repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "not found"));
        repository.deleteById(id);
    }
}
