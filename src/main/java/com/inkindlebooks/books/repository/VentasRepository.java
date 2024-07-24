package com.inkindlebooks.books.repository;

import com.inkindlebooks.books.model.entity.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VentasRepository extends JpaRepository<Ventas, Long> {

    @Query("SELECT v FROM Ventas v WHERE user.id = ?1")
    List<Ventas> findAllByUserId(Long userId);

}
