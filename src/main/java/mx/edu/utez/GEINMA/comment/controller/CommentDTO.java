package mx.edu.utez.GEINMA.comment.controller;

import mx.edu.utez.GEINMA.incedence.model.Incidence;
import mx.edu.utez.GEINMA.user.model.User;

public class CommentDTO {
    private long id;
    private String description;
    private String time;
    private User user;
    private Incidence incidence;

    public CommentDTO() {
    }

    public CommentDTO(long id, String description, String time, User user, Incidence incidence) {
        this.id = id;
        this.description = description;
        this.time = time;
        this.user = user;
        this.incidence = incidence;
    }

    public CommentDTO(String description, String time, User user, Incidence incidence) {
        this.description = description;
        this.time = time;
        this.user = user;
        this.incidence = incidence;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Incidence getIncidence() {
        return incidence;
    }

    public void setIncidence(Incidence incidence) {
        this.incidence = incidence;
    }
}
