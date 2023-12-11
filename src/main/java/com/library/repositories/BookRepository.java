package com.library.repositories;

import com.library.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findBookByName(String name);
    Optional<Book> findBookByAuthor(String author);
    Optional<Book> findBookById(Long id);
}
