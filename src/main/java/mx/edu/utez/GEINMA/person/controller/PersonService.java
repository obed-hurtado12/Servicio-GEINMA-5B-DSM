package mx.edu.utez.GEINMA.person.controller;

import mx.edu.utez.GEINMA.person.model.Person;
import mx.edu.utez.GEINMA.person.model.PersonRepository;
import mx.edu.utez.GEINMA.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@Transactional
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Message>findAll(){
        return new ResponseEntity<>(new Message("Ok", false, personRepository.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message>findById(long id){
        if (personRepository.existsById(id)){
            return new ResponseEntity<>(new Message("Ok", false, personRepository.findById(id)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("No existe la persona", true, null), HttpStatus.BAD_REQUEST);
    }

}
