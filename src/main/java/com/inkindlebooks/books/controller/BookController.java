package com.inkindlebooks.books.controller;

import com.inkindlebooks.books.model.dto.book.BookRequestDTO;
import com.inkindlebooks.books.model.dto.book.BookResponseDTO;
import com.inkindlebooks.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> getAllBooks(){
        List<BookResponseDTO> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable Long id){
        BookResponseDTO book =  bookService.getBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("/create-book")
    public ResponseEntity<BookResponseDTO> createBook(@Validated @RequestBody BookRequestDTO bookRequestDTO){
        BookResponseDTO createBook = bookService.createBook(bookRequestDTO);
        return new ResponseEntity<>(createBook, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(@Validated @PathVariable Long id, @RequestBody BookRequestDTO bookRequestDTO){
        BookResponseDTO updateBook = bookService.updateBook(id, bookRequestDTO);
        return new ResponseEntity<>(updateBook, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
