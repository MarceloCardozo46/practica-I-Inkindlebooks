package com.inkindlebooks.books.repository;

import com.inkindlebooks.books.model.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    @Query("SELECT s FROM ShoppingCart s WHERE s.user.id = ?1")
    Optional<ShoppingCart> findShoppingCartByUserId(Long id);
}
