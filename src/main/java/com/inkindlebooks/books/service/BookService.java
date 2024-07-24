package com.inkindlebooks.books.service;

import com.inkindlebooks.books.exception.ResourceNotFoundException;
import com.inkindlebooks.books.mapper.BookMapper;
import com.inkindlebooks.books.model.dto.book.BookRequestDTO;
import com.inkindlebooks.books.model.dto.book.BookResponseDTO;
import com.inkindlebooks.books.model.entity.Book;
import com.inkindlebooks.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Transactional(readOnly = true)
    public List<BookResponseDTO> getAllBooks(){
        List<Book> books = bookRepository.findAll();
        return bookMapper.convertToListDTO(books);
    }

    @Transactional(readOnly = true)
    public BookResponseDTO getBookById(Long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Create:Libro no encontrado con el número: " + id));
        return bookMapper.convertToDto(book);
    }
    
    @Transactional
    public BookResponseDTO createBook(BookRequestDTO bookRequestDTO){
        Book book = bookMapper.convertToEntity(bookRequestDTO);
        bookRepository.save(book);
        return bookMapper.convertToDto(book);
    }

    @Transactional
    public BookResponseDTO updateBook(Long id, BookRequestDTO bookRequestDTO){
        Book book = bookRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Update: Libro no encontrado: " + id));

        book.setImageName(bookRequestDTO.getImageName());
        book.setTitle(bookRequestDTO.getTitle());
        book.setAuthor(bookRequestDTO.getAuthor());
        book.setDescription(bookRequestDTO.getDescription());

        book = bookRepository.save(book);

        return bookMapper.convertToDto(book);
    }

    @Transactional
    public void deleteBook(Long id){bookRepository.deleteById(id);}

}
