package mx.edu.utez.GEINMA.status.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mx.edu.utez.GEINMA.incedence.model.Incidence;

import javax.persistence.*;
import java.util.List;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    @OneToMany(mappedBy = "status")
    @JsonIgnore
    private List<Incidence> incidences;

    public Status() {
    }

    public Status(String description) {
        this.description = description;
    }

    public Status(long id, String description) {
        this.id = id;
        this.description = description;
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
}
