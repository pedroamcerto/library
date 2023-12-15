package com.library.domain.Book;


import com.library.dtos.BookDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Entity(name = "books")
@Table(name = "books", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "author"}))
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) private Long id;
    private String name;
    private String author;
    private String description;
    private Long stock;
    private BigDecimal price;

    public Book(BookDTO data) {
        this.name = data.getName();
        this.author = data.getAuthor();
        this.description = data.getDescription();
        this.stock = data.getStock();
        this.price = data.getPrice();
    }
}
