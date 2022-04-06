package mx.edu.utez.GEINMA.security.controller;

import mx.edu.utez.GEINMA.security.model.AuthUser;
import mx.edu.utez.GEINMA.user.controller.UserService;
import mx.edu.utez.GEINMA.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.getByEmail(email).get();
        return AuthUser.build(user);
    }
}
