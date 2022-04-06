package mx.edu.utez.GEINMA.comment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mx.edu.utez.GEINMA.incedence.model.Incidence;
import mx.edu.utez.GEINMA.user.model.User;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private String time;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "incidence_is")
    private Incidence incidence;

    public Comment() {
    }

    public Comment(String description, String time, User user, Incidence incidence) {
        this.description = description;
        this.time = time;
        this.user = user;
        this.incidence = incidence;
    }

    public Comment(long id, String description, String time, User user, Incidence incidence) {
        this.id = id;
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
