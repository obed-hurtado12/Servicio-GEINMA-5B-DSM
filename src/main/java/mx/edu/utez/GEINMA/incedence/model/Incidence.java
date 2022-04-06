package mx.edu.utez.GEINMA.incedence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mx.edu.utez.GEINMA.comment.model.Comment;
import mx.edu.utez.GEINMA.experience.model.Experience;
import mx.edu.utez.GEINMA.status.model.Status;
import mx.edu.utez.GEINMA.user.model.User;

import javax.persistence.*;
import java.util.Base64;
import java.util.List;

@Entity
public class Incidence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String dateRegistered;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;
    @ManyToOne
    @JoinColumn(name = "technical_id")
    private User technical;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "experience_id")
    private Experience experience;
    @Column(name = "picture_incidence", columnDefinition = "longblob")
    private byte[] pictureIncidence;
    @OneToMany(mappedBy = "incidence")
    private List<Comment> comments;

    public Incidence() {
    }

    public Incidence(long id, String description, String dateRegistered, User client, User technical, Status status, Experience experience, byte[] pictureIncidence) {
        this.id = id;
        this.description = description;
        this.dateRegistered = dateRegistered;
        this.client = client;
        this.technical = technical;
        this.status = status;
        this.experience = experience;
        this.pictureIncidence = pictureIncidence;
    }

    public Incidence(String description, String dateRegistered, User client, Status status, byte[] pictureIncidence) {
        this.description = description;
        this.dateRegistered = dateRegistered;
        this.client = client;
        this.status = status;
        this.pictureIncidence = pictureIncidence;
    }

    public Incidence(String description, String dateRegistered, User client, User technical, Status status, Experience experience, byte[] pictureIncidence) {
        this.description = description;
        this.dateRegistered = dateRegistered;
        this.client = client;
        this.technical = technical;
        this.status = status;
        this.experience= experience;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public String getPictureIncidence() {
        return Base64.getEncoder().encodeToString(pictureIncidence);
    }

    public void setPictureIncidence(byte[] pictureIncidence) {
        this.pictureIncidence = pictureIncidence;
    }
}
