package com.example.bookstore.service;

import com.example.bookstore.model.Books;
import com.example.bookstore.repository.IBookRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookService implements IBookService {
    IBookRepository iBookRepository;

    @Override
    public Page<Books> findAll(Pageable pageable) {
        return iBookRepository.findAll(pageable);
    }

    @Override
    public Optional<Books> findById(Long id) {
        return iBookRepository.findById(id);
    }

    @Override
    public Books save(Books books) {
        return iBookRepository.save(books);
    }

    @Override
    public void deleteById(Long id) {
        iBookRepository.deleteById(id);
    }
}
