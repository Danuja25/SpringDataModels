package org.danuja25.springdata.user.model;

import javax.validation.constraints.Size;

public class User {

    private Long id;
    @Size(min = 3, message = "Username should be at least 3 characters long")
    private String username;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
