package com.library.domain;


import com.library.dtos.BookDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "books")
@Table(name = "books", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "author"}))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private String description;
    private Long stock;
    private BigDecimal price;

    public Book(BookDTO data) {
        this.name = data.name();
        this.author = data.author();
        this.description = data.description();
        this.stock = data.stock();
        this.price = data.price();
    }
}
