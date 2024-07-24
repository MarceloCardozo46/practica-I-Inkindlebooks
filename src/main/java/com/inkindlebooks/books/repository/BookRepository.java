package com.inkindlebooks.books.repository;

import com.inkindlebooks.books.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
