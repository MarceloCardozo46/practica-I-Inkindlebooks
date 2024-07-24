package com.inkindlebooks.books.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "comments")
public class Commentary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "commentary_text")
    private String commentaryText;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(name =  "book_id", nullable = false)
    private Book commendBook;

    public Commentary() {
    }

    public Commentary(Long id, String commentaryText, LocalDate createdAt, User author, Book commendBook) {
        this.id = id;
        this.commentaryText = commentaryText;
        this.createdAt = createdAt;
        this.author = author;
        this.commendBook = commendBook;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Book getCommendBook() {
        return commendBook;
    }

    public void setCommendBook(Book commendBook) {
        this.commendBook = commendBook;
    }
}
