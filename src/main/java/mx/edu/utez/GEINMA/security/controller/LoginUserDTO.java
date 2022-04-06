package mx.edu.utez.GEINMA.security.controller;

import javax.validation.constraints.NotBlank;

public class LoginUserDTO {
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    public LoginUserDTO() {
    }

    public LoginUserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
