package com.inkindlebooks.books.model.dto.sale;

import com.inkindlebooks.books.model.entity.Book;
import com.inkindlebooks.books.model.entity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class SaleRequestDTO {

    @NotNull(message = "La venta debe estar asociada a un usuario")
    private Long userId;

    @NotNull(message = "Debe haber libros asociados a la venta")
    private List<Long> booksId;

}
