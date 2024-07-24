package com.inkindlebooks.books.service;

import com.inkindlebooks.books.exception.ResourceNotFoundException;
import com.inkindlebooks.books.mapper.CommentaryMapper;
import com.inkindlebooks.books.model.dto.commentary.CommentaryRequestDTO;
import com.inkindlebooks.books.model.dto.commentary.CommentaryResponseDTO;
import com.inkindlebooks.books.model.entity.Commentary;
import com.inkindlebooks.books.repository.CommentaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommentaryService {

    @Autowired
    private CommentaryRepository commentaryRepository;
    @Autowired
    private CommentaryMapper commentaryMapper;

    @Transactional(readOnly = true)
    public List<CommentaryResponseDTO> getAllCommentary(){
        List<Commentary> commentaries = commentaryRepository.findAll();
        return commentaryMapper.convertToListDTO(commentaries);
    }

    @Transactional(readOnly = true)
    public CommentaryResponseDTO getCommentaryById(Long id){
        Commentary commentary = commentaryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Comentario no encontrado con el número: " + id));
        return commentaryMapper.convertToDto(commentary);
    }

    @Transactional(readOnly = true)
    public List<CommentaryResponseDTO> getAllCommentariesByBookId(Long id){
        List<Commentary> commentaries = commentaryRepository.findAllCommentariesByBookId(id);
        return commentaryMapper.convertToListDTO(commentaries);
    }

    @Transactional
    public CommentaryResponseDTO createCommentary(CommentaryRequestDTO commentaryRequestDTO){
        Commentary commentary = commentaryMapper.convertToEntity(commentaryRequestDTO);
        commentary.setCreatedAt(LocalDate.now());

        commentaryRepository.save(commentary);
        return commentaryMapper.convertToDto(commentary);
    }

    @Transactional
    public void deleteCommentary(Long id){
        commentaryRepository.deleteById(id);
    }

}
