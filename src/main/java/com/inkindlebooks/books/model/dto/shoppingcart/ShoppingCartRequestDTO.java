package com.inkindlebooks.books.model.dto.shoppingcart;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class ShoppingCartRequestDTO {

    @NotNull(message = "El carrito de compras debe tener un usuario asociado")
    private Long userId;

    private List<Long> booksId;


    public ShoppingCartRequestDTO() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getBooksId() {
        return booksId;
    }

    public void setBooksId(List<Long> booksId) {
        this.booksId = booksId;
    }
}
