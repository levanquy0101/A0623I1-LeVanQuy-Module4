package com.example.appbook.service;

import com.example.appbook.model.Borrow;

public interface IBorrowService {
    void save(Borrow borrow);

    Borrow findbyCode(Integer codeBorrow);

    void delete(Borrow borrow);
}
