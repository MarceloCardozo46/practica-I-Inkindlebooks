package com.inkindlebooks.books.service;

import com.inkindlebooks.books.util.EncriptadoSHA256;
import com.inkindlebooks.books.exception.ResourceNotFoundException;
import com.inkindlebooks.books.mapper.UserMapper;
import com.inkindlebooks.books.model.dto.user.UserRequestDTO;
import com.inkindlebooks.books.model.dto.user.UserResponseDTO;
import com.inkindlebooks.books.model.entity.User;
import com.inkindlebooks.books.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly = true)
    public UserResponseDTO getUserById(Long id){
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No se encontro un usuario con este id: " + id));
        return userMapper.convertToDto(user);
    }

    @Transactional
    public UserResponseDTO registerUser(UserRequestDTO userRequestDTO){
        User user = userMapper.convertToEntity(userRequestDTO);
//        user.setPassword(encriptadoSHA256.encryptWithSHA256(user.getPassword()));
        user.encryptPassword(user.getPassword());
        userRepository.save(user);
        return userMapper.convertToDto(user);
    }

    public UserResponseDTO loginUser(UserRequestDTO userRequestDTO){
        User userRequest = userMapper.convertToEntity(userRequestDTO);
        userRequest.encryptPassword(userRequest.getPassword());
        User userDB = userRepository.findByPassword(userRequest.getPassword(), userRequest.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Contraseña o correo electrónico erroneo"));
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        if(userDB != null){
            userResponseDTO = userMapper.convertToDto(userDB);
        } else {
            userResponseDTO = null;
        }
        return userResponseDTO;
    }

}
