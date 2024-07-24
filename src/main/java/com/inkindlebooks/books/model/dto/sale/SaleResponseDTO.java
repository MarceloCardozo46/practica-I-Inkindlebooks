package com.inkindlebooks.books.model.dto.sale;

import com.inkindlebooks.books.model.dto.book.BookRequestDTO;
import com.inkindlebooks.books.model.entity.Book;
import com.inkindlebooks.books.model.entity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

public class SaleResponseDTO {

    private Long id;
    private User user;
    private List<BookRequestDTO> books;

}
