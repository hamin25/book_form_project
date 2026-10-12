package org.example.webui.week06_assignment.repository;

import org.example.webui.week06_assignment.domain.Book;
import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book save(Book book);
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Book update(Book book);
    void deleteById(Long id);
}
