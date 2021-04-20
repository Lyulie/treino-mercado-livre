package com.ml.rodolpho.model;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ml.rodolpho.dto.UserDTOResponse;

@Entity
@Table(name = "t_user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "instant")
    private ZonedDateTime instant = ZonedDateTime.now();
    
    @Column(name = "login", unique = true)
    private String login;
    
    @Column(name = "password")
    private String password;

    public User() {
    }

    public User(Integer id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ZonedDateTime getInstant() {
        return this.instant;
    }

    public void setInstant(ZonedDateTime instant) {
        this.instant = instant;
    }

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

    public UserDTOResponse toResponse() {
        return new UserDTOResponse(this.id, this.instant, this.login);
    }
}
