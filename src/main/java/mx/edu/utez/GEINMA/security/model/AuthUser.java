package mx.edu.utez.GEINMA.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mx.edu.utez.GEINMA.person.model.Person;
import mx.edu.utez.GEINMA.role.model.Role;
import mx.edu.utez.GEINMA.user.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AuthUser implements UserDetails {
    private long id;
    private String email;
    @JsonIgnore
    private String password;
    private Person person;
    public Collection<? extends GrantedAuthority> role;

    public AuthUser(long id, String email, String password, Person person, Collection<? extends GrantedAuthority> role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.person = person;
        this.role = role;
    }

    public static AuthUser build(User user){
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(user.getRole().getDescription()));
        return new AuthUser(user.getId(), user.getEmail(), user.getPassword(), user.getPerson(), roles);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
