package com.library.controllers;

import com.library.domain.Book.Book;
import com.library.dtos.BookDTO;
import com.library.dtos.ResponseDTO;
import com.library.services.BookService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ResourceBundle;

@RestController()
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @PostMapping
    public ResponseEntity<ResponseDTO> createBook(@RequestBody BookDTO book){
        Book newBook = bookService.createBook(book);
        return new ResponseEntity<>(new ResponseDTO("Livro criado com sucesso!", 201), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = this.bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteBook(@PathVariable Long id){
        this.bookService.deleteBook(id);
        return new ResponseEntity<>(new ResponseDTO("Livro deletado com sucesso.", 200), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO book) throws Exception {
        Book updatedBook = this.bookService.updateBook(id, book);
        return new ResponseEntity<>(new ResponseDTO("Livro atualizado com sucesso", 200), HttpStatus.OK);

    }
}
