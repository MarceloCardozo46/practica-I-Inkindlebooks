package com.inkindlebooks.books.mapper;

import com.inkindlebooks.books.model.dto.commentary.CommentaryRequestDTO;
import com.inkindlebooks.books.model.dto.commentary.CommentaryResponseDTO;
import com.inkindlebooks.books.model.entity.Commentary;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentaryMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Commentary convertToEntity(CommentaryRequestDTO commentaryRequestDTO){
        return modelMapper.map(commentaryRequestDTO, Commentary.class);
    }

    public CommentaryResponseDTO convertToDto(Commentary commentary){
        return modelMapper.map(commentary, CommentaryResponseDTO.class);
    }

    public List<CommentaryResponseDTO> convertToListDTO(List<Commentary> commentaries){
        return commentaries.stream()
                .map(this::convertToDto)
                .toList();
    }

}
