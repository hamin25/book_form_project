package org.example.webui.week06_assignment.controller;

import org.springframework.stereotype.Controller;
import org.example.webui.week06_assignment.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/books")
public class BookWebController {
    private final BookService bookService;

    public BookWebController(BookService bookService) {
        this.bookService = bookService;
    }
}
