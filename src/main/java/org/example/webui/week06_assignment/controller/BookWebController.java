package org.example.webui.week06_assignment.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.example.webui.week06_assignment.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/books")
public class BookWebController {
    private final BookService bookService;

    public BookWebController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String list(Model model){
        model.addAttribute("books", bookService.findAll());
        return "books/list";
    }

    @GetMapping("/new")
    public String form(){
        return "books/form";
    }
}
