package org.example.webui.week06_assignment.controller;

import org.example.webui.week06_assignment.dto.*;
import org.example.webui.week06_assignment.service.BookService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) { this.bookService = bookService; }

    // TODO 11: POST /api/books - 생성 후 201 Created 반환
    @PostMapping
    public BookResponse create(@RequestBody BookRequest request) {
        return bookService.create(request);
    }

    // TODO 12: GET /api/books - 전체 조회
    @GetMapping
    public List<BookResponse> findAll() {
        return bookService.findAll();
    }

    // TODO 13: GET /api/books/{id} - 단건 조회
    @GetMapping("/{id}")
    public BookResponse findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    // TODO 14: PUT /api/books/{id} - 수정
    @PutMapping("/{id}")
    public BookResponse update(
            @PathVariable Long id,
            @RequestBody BookRequest request) {

        return bookService.update(id, request);
    }

    // TODO 15: DELETE /api/books/{id} - 삭제 후 204 No Content 반환
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }
}
