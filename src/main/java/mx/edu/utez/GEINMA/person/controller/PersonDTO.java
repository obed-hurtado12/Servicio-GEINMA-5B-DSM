package mx.edu.utez.GEINMA.person.controller;

import java.util.Base64;

public class PersonDTO {
    private int id;
    private String name;
    private String surname;
    private String secondSurname;
    private String phone;
    private String imageProfile;

    public PersonDTO() {
    }

    public PersonDTO(int id, String name, String surname, String secondSurname, String phone, String imageProfile) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.secondSurname = secondSurname;
        this.phone = phone;
        this.imageProfile = imageProfile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public byte[] getImageProfile() {
        return Base64.getDecoder().decode(imageProfile.replace(" ", "+"));
    }

    public void setImageProfile(String imageProfile) {
        this.imageProfile = imageProfile;
    }
}
