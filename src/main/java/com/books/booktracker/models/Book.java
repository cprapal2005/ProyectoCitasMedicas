package com.books.booktracker.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "books")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return "";
    }
}
