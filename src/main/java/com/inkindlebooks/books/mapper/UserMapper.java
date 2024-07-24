package com.inkindlebooks.books.mapper;

import com.inkindlebooks.books.model.dto.user.UserRequestDTO;
import com.inkindlebooks.books.model.dto.user.UserResponseDTO;
import com.inkindlebooks.books.model.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public User convertToEntity(UserRequestDTO userRequestDTO){
        return modelMapper.map(userRequestDTO, User.class);
    }

    public UserResponseDTO convertToDto(User user){
        return modelMapper.map(user, UserResponseDTO.class);
    }

    public List<UserResponseDTO> convertToListDTO(List<User> users){
        return users.stream()
                .map(this::convertToDto)
                .toList();
    }

}
