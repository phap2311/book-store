package com.example.bookstore.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, length = 255)
    @NotBlank(message = "Title is required")
    String title;
    @Column(nullable = false, length = 255)
    @NotBlank(message = "Author is required")
    String author;
    LocalDate published_date;
    @Column(nullable = false, unique = true, length = 13)
    @NotBlank(message = "ISBN is required")
    @Size(min = 10, max = 13, message = "ISBN should be 10 or 13 characters long")
    String isbn;
    @Column(nullable = false, precision = 10, scale = 2)
    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
    BigDecimal price;
}
