package com.inkindlebooks.books.mapper;

import com.inkindlebooks.books.model.dto.sale.SaleRequestDTO;
import com.inkindlebooks.books.model.dto.sale.SaleResponseDTO;
import com.inkindlebooks.books.model.entity.Ventas;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VentasMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Ventas convertToEntity(SaleRequestDTO saleRequestDTO){
        return modelMapper.map(saleRequestDTO, Ventas.class);
    }

    public SaleResponseDTO convertToDto(Ventas ventas){
        return modelMapper.map(ventas, SaleResponseDTO.class);
    }

    public List<SaleResponseDTO> convertToListDTO(List<Ventas> ventas){
        return ventas.stream()
                .map(this::convertToDto)
                .toList();
    }

}
