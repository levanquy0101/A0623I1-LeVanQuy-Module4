package com.example.appbook.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(unique = true)
    private Integer codeBorrow;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @Column
    private LocalDate borrowDate;
    @Column
    private LocalDate loanDate;

    public Borrow() {
    }

    public Borrow(Integer codeBorrow, Book book, User user, LocalDate borrowDate) {
        this.codeBorrow = codeBorrow;
        this.book = book;
        this.user = user;
        this.borrowDate = borrowDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodeBorrow() {
        return codeBorrow;
    }

    public void setCodeBorrow(Integer codeBorrow) {
        this.codeBorrow = codeBorrow;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }
}
