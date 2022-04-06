package mx.edu.utez.GEINMA.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mx.edu.utez.GEINMA.comment.model.Comment;
import mx.edu.utez.GEINMA.incedence.model.Incidence;
import mx.edu.utez.GEINMA.person.model.Person;
import mx.edu.utez.GEINMA.role.model.Role;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "person_id")
    private Person person;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Incidence> incidencesClient;
    @OneToMany(mappedBy = "technical")
    @JsonIgnore
    private List<Incidence> incidencesTechnical;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Comment> comments;

    public User() {
    }

    public User(long id, String email, String password, Person person, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.person = person;
        this.role = role;
    }

    public User(String email, String password, Person person, Role role) {
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
