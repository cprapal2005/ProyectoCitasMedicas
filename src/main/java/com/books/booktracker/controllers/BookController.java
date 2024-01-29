package com.books.booktracker.controllers;

import com.books.booktracker.models.Book;
import com.books.booktracker.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getBooks")
    public List<Book> getBooks() { return bookService.getBooks(); }

    @PostMapping("/saveBook")
    public Book saveBook(@RequestBody Book book) { return bookService.saveBook(book); }
}
