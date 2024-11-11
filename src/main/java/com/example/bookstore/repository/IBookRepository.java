package com.example.bookstore.repository;

import com.example.bookstore.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Books,Long> {

}
