package com.library.services;

import com.library.domain.Book.Book;
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
        return this.repository.findById(id).orElseThrow(() -> new Exception("Não foi possível encontrar nenhum livro."));
    }
    public void saveBook(Book book){
        this.repository.save(book);
    }

    public Book createBook(BookDTO data){
        Book newBook = new Book(data);
        this.saveBook(newBook);
        return newBook;
    }
    public void deleteBook(Long id){
        this.repository.deleteById(id);
    }
    public Book updateBook(Long id, BookDTO data) throws Exception{
        Book updatedBook = this.findBookById(id);

        updatedBook.setAuthor(data.getAuthor());
        updatedBook.setName(data.getName());
        updatedBook.setDescription(data.getDescription());
        updatedBook.setPrice(data.getPrice());
        updatedBook.setStock(data.getStock());

        this.saveBook(updatedBook);
        return updatedBook;
    }
    public List<Book> getAllBooks(){
        return this.repository.findAll();
    }

}