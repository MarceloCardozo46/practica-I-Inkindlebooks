package com.inkindlebooks.books.model.dto.book;

import jakarta.validation.constraints.*;
import jakarta.persistence.Column;


public class BookRequestDTO {

    public BookRequestDTO() {
    }

    public BookRequestDTO(String imageName, String title, String author, String description) {
        this.imageName = imageName;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    @NotBlank(message = "El libro debe tener una imagen de referencias")
    private String imageName;
    @NotBlank(message = "El libro debe tener un título")
    private String title;
    @NotBlank(message = "El libro debe tener un autor")
    private String author;
    @NotBlank(message = "El libro debe tener una descripción")
    private String description;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
