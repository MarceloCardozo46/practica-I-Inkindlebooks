package com.inkindlebooks.books.repository;

import com.inkindlebooks.books.model.entity.Commentary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentaryRepository extends JpaRepository<Commentary, Long> {

    @Query("SELECT c FROM Commentary c WHERE c.commendBook.id = :id")
    List<Commentary> findAllCommentariesByBookId(@Param("id") Long id);

}
