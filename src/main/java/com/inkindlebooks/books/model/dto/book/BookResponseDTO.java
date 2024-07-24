package com.inkindlebooks.books.model.dto.book;

public class BookResponseDTO {

    private Long id;
    private String imageName;
    private String title;
    private String author;
    private String description;


    public BookResponseDTO() {
    }

    public BookResponseDTO(Long id, String imageName, String title, String author, String description) {
        this.id = id;
        this.imageName = imageName;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
