package com.example.bookstore.service;

import com.example.bookstore.model.Books;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBookService {
    Page<Books> findAll(Pageable pageable);

    Optional<Books> findById(Long id);

    Books save(Books books);

    void deleteById(Long id);
}
