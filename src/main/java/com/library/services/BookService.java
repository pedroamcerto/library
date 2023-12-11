package com.library.services;

import com.library.domain.Book;
import com.library.dtos.BookDTO;
import com.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService
{
    @Autowired
    private BookRepository repository;

    public Book findBookById(Long id) throws Exception {
        return this.repository.findBookById(id).orElseThrow(() -> new Exception("Livro não encontrado"));
    }
    public void saveBook(Book book){
        this.repository.save(book);
    }

    public Book createBook(BookDTO data){
        Book newBook = new Book(data);
        this.saveBook(newBook);
        return newBook;
    }

    public List<Book> getAllBooks(){
        return this.repository.findAll();
    }

}
