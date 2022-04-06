package mx.edu.utez.GEINMA.user.controller;

import mx.edu.utez.GEINMA.person.model.Person;
import mx.edu.utez.GEINMA.person.model.PersonRepository;
import mx.edu.utez.GEINMA.user.model.User;
import mx.edu.utez.GEINMA.user.model.UserRepository;
import mx.edu.utez.GEINMA.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PersonRepository personRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Message>findAll(){
        return new ResponseEntity<>(new Message("Ok", false, userRepository.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findByRole(long id){
        return new ResponseEntity<>(new Message("Ok", false, userRepository.findAllByRoleId(id)), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public Optional<User>getByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message>save(User user){
        if (userRepository.existsByEmail(user.getEmail())){
            return new ResponseEntity<>(new Message("El correo ya esta registrado", true, null), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Message("Ok", false, userRepository.saveAndFlush(user)), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message>update(User user){
        if (!userRepository.existsById(user.getId())){
            return new ResponseEntity<>(new Message("El usuario no existe", true, null), HttpStatus.BAD_REQUEST);
        }
        Person personTemp = user.getPerson();
        personTemp = personRepository.saveAndFlush(personTemp);
        user.setPerson(personTemp);
        return new ResponseEntity<>(new Message("Ok", false, userRepository.saveAndFlush(user)), HttpStatus.OK);
    }
}
