package mx.edu.utez.GEINMA.user.controller;

import mx.edu.utez.GEINMA.person.model.Person;
import mx.edu.utez.GEINMA.user.model.User;
import mx.edu.utez.GEINMA.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"*"})
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public ResponseEntity<Message> getAll() {
        return userService.findAll();
    }

    @GetMapping("role/{role}")
    public ResponseEntity<Message> getByRole(@PathVariable("role") long id) {
        return userService.findByRole(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> save(@RequestBody UserDTO userDTO) {
        Person person = new Person(userDTO.getPerson().getId(), userDTO.getPerson().getName(),
                userDTO.getPerson().getSurname(), userDTO.getPerson().getSecondSurname(), userDTO.getPerson().getPhone(),
                userDTO.getPerson().getImageProfile());
        return userService.save(new User(
                userDTO.getEmail(),
                passwordEncoder.encode(userDTO.getPassword()),
                person,
                userDTO.getRole()
        ));
    }

    @PutMapping("/")
    public ResponseEntity<Message> update(@RequestBody UserDTO userDTO) {
        Person person = new Person(userDTO.getPerson().getId(), userDTO.getPerson().getName(),
                userDTO.getPerson().getSurname(), userDTO.getPerson().getSecondSurname(), userDTO.getPerson().getPhone(),
                userDTO.getPerson().getImageProfile());
        return userService.update(new User(
                userDTO.getEmail(),
                passwordEncoder.encode(userDTO.getPassword()),
                person,
                userDTO.getRole()
        ));
    }
}
