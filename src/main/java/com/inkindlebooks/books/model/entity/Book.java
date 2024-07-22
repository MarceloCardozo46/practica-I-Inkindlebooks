package com.inkindlebooks.books.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "image_name")
    private String imageName;
    @Column(name = "title")
    private String title;
    private String author;
    private String description;


}
