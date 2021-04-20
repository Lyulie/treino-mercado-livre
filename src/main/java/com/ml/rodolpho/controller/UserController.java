package com.ml.rodolpho.controller;

import javax.validation.Valid;

import com.ml.rodolpho.dto.UserDTORequest;
import com.ml.rodolpho.dto.UserDTOResponse;
import com.ml.rodolpho.model.User;
import com.ml.rodolpho.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping(value = "signup")
    public ResponseEntity<UserDTOResponse> newUser (@Valid @RequestBody UserDTORequest dto) {
        
        User user = dto.toUser();
        
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(userService.signUp(user).toResponse());
    }

    @PostMapping(value = "login")
    public ResponseEntity<UserDTOResponse> login (@Valid @RequestBody UserDTORequest dto) throws Exception {
        
        User user = dto.toUser();
        
        return ResponseEntity.status(HttpStatus.OK)
            .body(userService.login(user).toResponse());
    }
}
