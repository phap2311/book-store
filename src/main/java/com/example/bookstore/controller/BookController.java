package com.example.bookstore.controller;

import com.example.bookstore.exception.ApiException;
import com.example.bookstore.exception.ErrorCode;
import com.example.bookstore.model.Books;
import com.example.bookstore.service.IBookService;
import com.example.bookstore.util.JsonResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@CrossOrigin("*")
public class BookController {
    IBookService iBookService;

    @GetMapping
    public ResponseEntity<?> getAll(@PageableDefault(size = 10) Pageable pageable) {
        return JsonResponse.ok(iBookService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        return iBookService.findById(id)
                .map(JsonResponse::ok)
                .orElseThrow(() -> new ApiException(ErrorCode.BOOK_NOT_EXIST));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Books books) {
        iBookService.save(books);
        return JsonResponse.created(books);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Books books) {
        Books books1 = iBookService.findById(id)
                .orElseThrow(() -> new ApiException(ErrorCode.BOOK_NOT_EXIST));
        books.setId(books1.getId());
        iBookService.save(books);
        return JsonResponse.ok(books);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        Books books = iBookService.findById(id)
                .orElseThrow(() -> new ApiException(ErrorCode.BOOK_NOT_EXIST));
        iBookService.deleteById(books.getId());
        return JsonResponse.ok("Book deleted successfully");
    }
}
