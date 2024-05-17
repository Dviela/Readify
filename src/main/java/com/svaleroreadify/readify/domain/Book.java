package com.svaleroreadify.readify.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @Column
    private String author;

    @Column(name = "published_date")
    private LocalDate publishedDate;

    @Column
    private String ISBN;

    @Column
    private Boolean available;

    @Column(name = "page_count")
    private int pageCount;

    @OneToMany
    @JoinColumn(name = "loan_id")
    private List<Loan> loan;
}
