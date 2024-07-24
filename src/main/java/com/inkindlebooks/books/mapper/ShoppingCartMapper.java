package com.inkindlebooks.books.mapper;

import com.inkindlebooks.books.model.dto.shoppingcart.ShoppingCartRequestDTO;
import com.inkindlebooks.books.model.dto.shoppingcart.ShoppingCartResponseDTO;
import com.inkindlebooks.books.model.entity.ShoppingCart;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShoppingCartMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ShoppingCart convertToEntity(ShoppingCartRequestDTO shoppingCartRequestDTO){
        return modelMapper.map(shoppingCartRequestDTO, ShoppingCart.class);
    }

    public ShoppingCartResponseDTO convertToDto(ShoppingCart shoppingCart){
        return modelMapper.map(shoppingCart, ShoppingCartResponseDTO.class);
    }

    public List<ShoppingCartResponseDTO> convertToListDTO(List<ShoppingCart> shoppingCarts){
        return shoppingCarts.stream()
                .map(this::convertToDto)
                .toList();
    }

}
