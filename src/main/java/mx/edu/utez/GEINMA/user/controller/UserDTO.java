package mx.edu.utez.GEINMA.user.controller;

import mx.edu.utez.GEINMA.person.controller.PersonDTO;
import mx.edu.utez.GEINMA.person.model.Person;
import mx.edu.utez.GEINMA.role.model.Role;

public class UserDTO {
    private long id;
    private String email;
    private String password;
    private PersonDTO person;
    private Role role;

    public UserDTO() {
    }

    public UserDTO(long id, String email, String password, PersonDTO person, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.person = person;
        this.role = role;
    }

    public UserDTO(String email, String password, PersonDTO person, Role role) {
        this.email = email;
        this.password = password;
        this.person = person;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public PersonDTO getPerson() {
        return person;
    }

    public void setPerson(PersonDTO person) {
        this.person = person;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
