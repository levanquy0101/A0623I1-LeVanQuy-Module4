package com.example.appbook.service.impl;

import com.example.appbook.model.Borrow;
import com.example.appbook.repository.IBookRepository;
import com.example.appbook.repository.IBorrowRepository;
import com.example.appbook.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowService implements IBorrowService {
    @Autowired
    private IBorrowRepository iBorrowRepository;

    @Override
    public void save(Borrow borrow) {
        iBorrowRepository.save(borrow);
    }

    @Override
    public Borrow findbyCode(Integer codeBorrow) {
        return iBorrowRepository.findByCodeBorrow(codeBorrow);
    }

    @Override
    public void delete(Borrow borrow) {
        iBorrowRepository.delete(borrow);
    }
}
