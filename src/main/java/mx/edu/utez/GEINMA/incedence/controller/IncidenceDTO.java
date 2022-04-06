package mx.edu.utez.GEINMA.incedence.controller;

import mx.edu.utez.GEINMA.experience.model.Experience;
import mx.edu.utez.GEINMA.status.model.Status;
import mx.edu.utez.GEINMA.user.model.User;

import java.util.Base64;

public class IncidenceDTO {
    private long id;
    private String description;
    private String dateRegistered;
    private User client;
    private User technical;
    private Status status;
    private Experience experience;
    private String pictureIncidence;
    private String token;

    public IncidenceDTO() {
    }

    public IncidenceDTO(long id, String description, String dateRegistered, User client, User technical, Status status, Experience experience, String pictureIncidence) {
        this.id = id;
        this.description = description;
        this.dateRegistered = dateRegistered;
        this.client = client;
        this.technical = technical;
        this.status = status;
        this.experience = experience;
        this.pictureIncidence = pictureIncidence;
    }

    public IncidenceDTO(String description, String dateRegistered, User client, Status status, String pictureIncidence, String token) {
        this.description = description;
        this.dateRegistered = dateRegistered;
        this.client = client;
        this.status = status;
        this.pictureIncidence = pictureIncidence;
        this.token = token;
    }

    public IncidenceDTO(long id, String description, String dateRegistered, User client, User technical, Status status, String pictureIncidence) {
        this.id = id;
        this.description = description;
        this.dateRegistered = dateRegistered;
        this.client = client;
        this.technical = technical;
        this.status = status;
        this.pictureIncidence = pictureIncidence;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(String dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public User getTechnical() {
        return technical;
    }

    public void setTechnical(User technical) {
        this.technical = technical;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public byte[] getPictureIncidence() {
        return Base64.getDecoder().decode(pictureIncidence.replace(" ","+"));
    }

    public void setPictureIncidence(String pictureIncidence) {
        this.pictureIncidence = pictureIncidence;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
