package mx.edu.utez.GEINMA.person.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mx.edu.utez.GEINMA.user.model.User;

import javax.persistence.*;
import java.util.Base64;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    @Column(name = "second_surname")
    private String secondSurname;
    private String phone;
    @Column(name = "image_profile", columnDefinition = "longblob")
    private byte[] imageProfile;
    @OneToOne(mappedBy = "person")
    @JsonIgnore
    private User user;

    public Person() {
    }

    public Person(String name, String surname, String secondSurname, String phone, byte[] imageProfile) {
        this.name = name;
        this.surname = surname;
        this.secondSurname = secondSurname;
        this.phone = phone;
        this.imageProfile = imageProfile;
    }

    public Person(String name, String surname, String phone, byte[] imageProfile) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.imageProfile = imageProfile;
    }

    public Person(long id, String name, String surname, String secondSurname, String phone, byte[] imageProfile) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.secondSurname = secondSurname;
        this.phone = phone;
        this.imageProfile = imageProfile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageProfile() {
        return Base64.getEncoder().encodeToString(imageProfile);
    }

    public void setImageProfile(byte[] imageProfile) {
        this.imageProfile = imageProfile;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
