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
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column(name = "membership_date")
    private LocalDate membershipDate;

    @Column
    private Boolean active;

    @Column
    private int role;

    @OneToMany
    @JoinColumn(name = "loan_id")
    private List<Loan> loan;
}
