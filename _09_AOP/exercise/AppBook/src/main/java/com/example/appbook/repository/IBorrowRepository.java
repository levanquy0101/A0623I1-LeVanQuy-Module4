package com.example.appbook.repository;

import com.example.appbook.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowRepository extends JpaRepository<Borrow, Long> {
    Borrow findByCodeBorrow(Integer codeBorrow);
}
