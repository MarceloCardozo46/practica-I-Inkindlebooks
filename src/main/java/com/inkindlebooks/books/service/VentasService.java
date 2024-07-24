package com.inkindlebooks.books.service;

import com.inkindlebooks.books.exception.ResourceNotFoundException;
import com.inkindlebooks.books.mapper.VentasMapper;
import com.inkindlebooks.books.model.dto.sale.SaleRequestDTO;
import com.inkindlebooks.books.model.dto.sale.SaleResponseDTO;
import com.inkindlebooks.books.model.entity.Ventas;
import com.inkindlebooks.books.repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VentasService {

    @Autowired
    private VentasRepository ventasRepository;
    @Autowired
    private VentasMapper ventasMapper;

    @Transactional(readOnly = true)
    public SaleResponseDTO getVentaById(Long id){
        Ventas ventas = ventasRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Venta no encontrada con el número: " + id));
        return ventasMapper.convertToDto(ventas);
    }

    @Transactional(readOnly = true)
    public List<SaleResponseDTO> getAllVentasByUserId(Long userId){
        List<Ventas> ventasList = ventasRepository.findAllByUserId(userId);
        return ventasMapper.convertToListDTO(ventasList);
    }

    @Transactional
    public SaleResponseDTO createVentas(SaleRequestDTO saleRequestDTO){
        Ventas ventas = ventasMapper.convertToEntity(saleRequestDTO);

        ventasRepository.save(ventas);
        return ventasMapper.convertToDto(ventas);
    }

    public void deleteVentas(Long id){
        ventasRepository.deleteById(id);
    }
}
