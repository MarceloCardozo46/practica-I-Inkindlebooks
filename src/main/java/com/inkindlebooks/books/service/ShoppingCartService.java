package com.inkindlebooks.books.service;

import com.inkindlebooks.books.exception.ResourceNotFoundException;
import com.inkindlebooks.books.mapper.ShoppingCartMapper;
import com.inkindlebooks.books.model.dto.shoppingcart.ShoppingCartRequestDTO;
import com.inkindlebooks.books.model.dto.shoppingcart.ShoppingCartResponseDTO;
import com.inkindlebooks.books.model.entity.Book;
import com.inkindlebooks.books.model.entity.ShoppingCart;
import com.inkindlebooks.books.repository.BookRepository;
import com.inkindlebooks.books.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Autowired
    private BookRepository bookRepository;

    @Transactional(readOnly = true)
    public ShoppingCartResponseDTO getShoppingCartById(Long id){
        ShoppingCart shoppingCart = shoppingCartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carrito de compras no encontrado"));
        return  shoppingCartMapper.convertToDto(shoppingCart);
    }

    @Transactional(readOnly = true)
    public ShoppingCartResponseDTO getShoppingCartByUserId(Long id){
        ShoppingCart shoppingCart = shoppingCartRepository.findShoppingCartByUserId(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el carrito de compras del usuario: " +  id));
        return shoppingCartMapper.convertToDto(shoppingCart);
    }

    @Transactional
    public ShoppingCartResponseDTO createShoppingCart(ShoppingCartRequestDTO shoppingCartRequestDTO){
        ShoppingCart shoppingCart = shoppingCartMapper.convertToEntity(shoppingCartRequestDTO);
        shoppingCartRepository.save(shoppingCart);
        return shoppingCartMapper.convertToDto(shoppingCart);
    }

    @Transactional
    public ShoppingCartResponseDTO updateShoppingCart(Long id, ShoppingCartRequestDTO shoppingCartRequestDTO){
        ShoppingCart shoppingCart = shoppingCartRepository.findShoppingCartByUserId(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el carrito de compras del usuario: " +  id));
        List<Book> bookList = new ArrayList<>();
        shoppingCartRequestDTO.getBooksId().forEach(bookId -> {
            Book book = bookRepository.findById(bookId)
                    .orElseThrow(() -> new ResourceNotFoundException("No se encontro el libro con el id: " + id));
            bookList.add(book);
        });

        shoppingCart.setBooks(bookList);
        shoppingCartRepository.save(shoppingCart);
        return shoppingCartMapper.convertToDto(shoppingCart);
    }

    @Transactional
    public void deleteShoppingCart(Long id){
        shoppingCartRepository.deleteById(id);
    }
}
