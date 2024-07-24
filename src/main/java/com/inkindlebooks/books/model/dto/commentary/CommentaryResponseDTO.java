package com.inkindlebooks.books.model.dto.commentary;

import com.inkindlebooks.books.model.dto.book.BookRequestDTO;
import com.inkindlebooks.books.model.dto.user.UserRequestDTO;
import com.inkindlebooks.books.model.entity.Book;
import com.inkindlebooks.books.model.entity.User;

import java.time.LocalDate;

public class CommentaryResponseDTO {

    private Long id;
    private String commentaryText;
    private LocalDate createdAt;
    private UserRequestDTO author;
    private BookRequestDTO commendBook;


    public CommentaryResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentaryText() {
        return commentaryText;
    }

    public void setCommentaryText(String commentaryText) {
        this.commentaryText = commentaryText;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public UserRequestDTO getAuthor() {
        return author;
    }

    public void setAuthor(UserRequestDTO author) {
        this.author = author;
    }

    public BookRequestDTO getCommendBook() {
        return commendBook;
    }

    public void setCommendBook(BookRequestDTO commendBook) {
        this.commendBook = commendBook;
    }
}
