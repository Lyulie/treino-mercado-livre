package com.ml.rodolpho.service;

import com.ml.rodolpho.config.security.BcryptEncoderService;
import com.ml.rodolpho.model.User;
import com.ml.rodolpho.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    public static final String USER_OR_PASSWORD_DONT_MATCHES_MSG = "Username or password incorrect!";
    public static final String USER_ALREADY_REGISTERED_MSG = "An user with this email already registered!";
    
    @Autowired
    UserRepository userRepository;

    public User signUp(User user) {
        validateSignUp(user);
        user.setPassword(BcryptEncoderService.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void validateSignUp(User user) {
        if(userRepository.findByLogin(user.getLogin()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, USER_ALREADY_REGISTERED_MSG);
        }
    }

    public User login(User user) throws Exception {
        User userTemporary = userRepository.findByLogin(user.getLogin());
        if(
            userTemporary != null &&
            BcryptEncoderService.matches(user.getPassword(), userTemporary.getPassword())
        )
            return userTemporary;
        
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, USER_OR_PASSWORD_DONT_MATCHES_MSG);
    }
}
