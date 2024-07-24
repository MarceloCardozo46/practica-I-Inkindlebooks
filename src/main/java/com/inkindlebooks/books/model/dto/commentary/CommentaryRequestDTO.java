package com.inkindlebooks.books.model.dto.commentary;

import com.inkindlebooks.books.model.entity.Book;
import com.inkindlebooks.books.model.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CommentaryRequestDTO {

    @NotBlank(message = "El comentario no puede estar vacío")
    private String commentaryText;

    @NotNull(message = "El comentario debe estar asociado a algún usuario")
    private Long authorId;

    @NotNull(message = "El comentario debe estar asociado a algún libro")
    private Long commendBookId;

    private LocalDate createdAt;


    public CommentaryRequestDTO() {
    }

    public String getCommentaryText() {
        return commentaryText;
    }

    public void setCommentaryText(String commentaryText) {
        this.commentaryText = commentaryText;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getCommendBookId() {
        return commendBookId;
    }

    public void setCommendBookId(Long commendBookId) {
        this.commendBookId = commendBookId;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
