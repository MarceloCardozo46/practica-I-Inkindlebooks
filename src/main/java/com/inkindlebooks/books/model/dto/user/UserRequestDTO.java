package com.inkindlebooks.books.model.dto.user;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {

    @NotBlank(message = "El  user")
    @Size(min = 5, max = 20, message = "El nombre de usuario debe tener entre 5 y 20 carácteres")
    private String username;
    @NotBlank(message = "El correo electrónico no puede estar vacío")
    @Email
    private String email;
    @NotBlank(message = "La contraseña no puede estar vacía")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=]).{12,}$", message = "La contraseña debe tener al menos una letra mayúscula, un dígito, un carácter especial, y tenga al menos 12 caracteres de longitud.")
    private String password;

}
