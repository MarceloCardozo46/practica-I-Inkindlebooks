package com.inkindlebooks.books.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "shopping_carts")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = User.class, cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "user_id")
    private User user;


    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
    private List<Book> books;

    public ShoppingCart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    /*public void addBook(List<Long> idBooks){
        List<Book> bookList =
    }*/
}
