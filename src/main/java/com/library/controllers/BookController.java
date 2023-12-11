package com.library.controllers;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.library.domain.Book;
import com.library.dtos.BookDTO;
import com.library.services.BookService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody BookDTO book){
        Book newBook = bookService.createBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = this.bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);

    }
}
