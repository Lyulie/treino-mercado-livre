package com.ml.rodolpho.dto;

import java.time.ZonedDateTime;

public class UserDTOResponse {
    
    private Integer id;
    private ZonedDateTime instant;
    private String login;

    public UserDTOResponse(Integer id, ZonedDateTime instant, String login) {
        this.id = id;
        this.instant = instant;
        this.login = login;
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
}
