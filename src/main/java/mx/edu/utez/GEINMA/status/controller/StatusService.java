package mx.edu.utez.GEINMA.status.controller;

import mx.edu.utez.GEINMA.role.model.Role;
import mx.edu.utez.GEINMA.status.model.Status;
import mx.edu.utez.GEINMA.status.model.StatusRepository;
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
public class StatusService {
    @Autowired
    StatusRepository statusRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("OK", false, statusRepository.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message>findById(long id){
        if (statusRepository.existsById(id)){
            return new ResponseEntity<>(new Message("Ok", false, statusRepository.findById(id)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("No se encontró", true, null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message>save(Status status){
        Optional<Status> existStatus = statusRepository.findByDescription(status.getDescription());
        if (existStatus.isPresent()){
            return new ResponseEntity<>(new Message("Ya existe el status", true, null), HttpStatus.BAD_REQUEST);
        }
        Status savedStatus = statusRepository.saveAndFlush(status);
        return new ResponseEntity<>(new Message("OK", false, savedStatus), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message>update(Status status){
        if (statusRepository.existsById(status.getId())){
            return new ResponseEntity<>(new Message("Ok", false, statusRepository.saveAndFlush(status)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("No existe el status", true, null),HttpStatus.BAD_REQUEST);
    }
}
