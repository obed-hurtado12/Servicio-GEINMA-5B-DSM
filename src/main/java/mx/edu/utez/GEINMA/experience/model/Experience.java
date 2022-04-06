package mx.edu.utez.GEINMA.experience.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mx.edu.utez.GEINMA.incedence.model.Incidence;

import javax.persistence.*;

@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "text")
    private String description;
    private int score;
    @OneToOne(mappedBy = "experience")
    @JsonIgnore
    private Incidence incidence;

    public Experience() {
    }

    public Experience(long id, String description, int score) {
        this.id = id;
        this.description = description;
        this.score = score;
    }

    public Experience(String description, int score) {
        this.description = description;
        this.score = score;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
