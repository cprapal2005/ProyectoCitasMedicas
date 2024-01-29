package com.books.booktracker.services;

import com.books.booktracker.models.Book;
import com.books.booktracker.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    BookRepository bookRepository;

    public BookService(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return (ArrayList<Book>) bookRepository.findAll();
    }

    // i create a new Book to avoid passing more parameters than i want to (for example, passing the id)
    public Book saveBook(Book book) { return bookRepository.save(new Book(book.getTitle())); }
}
