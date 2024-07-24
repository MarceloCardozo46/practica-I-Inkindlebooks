package com.inkindlebooks.books.mapper;

import com.inkindlebooks.books.model.dto.book.BookRequestDTO;
import com.inkindlebooks.books.model.dto.book.BookResponseDTO;
import com.inkindlebooks.books.model.entity.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Book convertToEntity(BookRequestDTO bookRequestDTO){
        return modelMapper.map(bookRequestDTO, Book.class);
    }

    public BookResponseDTO convertToDto(Book book){
        return modelMapper.map(book, BookResponseDTO.class);
    }

    public List<BookResponseDTO> convertToListDTO(List<Book> books){
        return books.stream()
                .map(this::convertToDto)
                .toList();
    }
}
