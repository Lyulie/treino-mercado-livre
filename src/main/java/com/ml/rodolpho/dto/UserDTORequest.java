package com.ml.rodolpho.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.ml.rodolpho.model.User;

public class UserDTORequest {
        
    @NotBlank(message = "O email não pode ser vazio!")
    @Email(message = "Email inválido!")
    private String login;

    @NotBlank(message = "A senha não pode ser vazia!")
    @Size(min = 3, max = 255, message = "A senha deve ter entre 3 a 255 caracteres!")
    private String password;

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User toUser() {
        return new User(null, this.login, this.password);
    }
}
