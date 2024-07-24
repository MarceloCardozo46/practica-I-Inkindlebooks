package com.inkindlebooks.books.model.dto.shoppingcart;

import com.inkindlebooks.books.model.dto.book.BookRequestDTO;
import com.inkindlebooks.books.model.dto.user.UserRequestDTO;

import java.util.List;

public class ShoppingCartResponseDTO {

    private Long id;

    private UserRequestDTO user;

    private List<BookRequestDTO> books;


    public ShoppingCartResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRequestDTO getUser() {
        return user;
    }

    public void setUser(UserRequestDTO user) {
        this.user = user;
    }

    public List<BookRequestDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookRequestDTO> books) {
        this.books = books;
    }
}
