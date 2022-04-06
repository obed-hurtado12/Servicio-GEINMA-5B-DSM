package mx.edu.utez.GEINMA.incedence.controller;

import mx.edu.utez.GEINMA.incedence.model.Incidence;
import mx.edu.utez.GEINMA.incedence.model.IncidenceRepository;
import mx.edu.utez.GEINMA.user.model.UserRepository;
import mx.edu.utez.GEINMA.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@Transactional
public class IncidenceService {
    @Autowired
    IncidenceRepository incidenceRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("Ok", false, incidenceRepository.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id){
        if (incidenceRepository.existsById(id)){
            return new ResponseEntity<>(new Message("Ok", false, incidenceRepository.findById(id)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("Incidencia no existe", true, null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAllByClient(long id){
            return new ResponseEntity<>(new Message("Ok", false, incidenceRepository.findAllByClientId(id)), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAllByStatus(long id){
            return new ResponseEntity<>(new Message("Ok", false, incidenceRepository.findAllByStatusId(id)), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAllByTechnical(long id){
            return new ResponseEntity<>(new Message("Ok", false, incidenceRepository.findAllByTechnicalId(id)), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> save(Incidence incidence){
        return new ResponseEntity<>(new Message("Ok", false, incidenceRepository.saveAndFlush(incidence)), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(Incidence incidence){
        if (incidenceRepository.existsById(incidence.getId())){
            return new ResponseEntity<>(new Message("La incidencia no existe!", true, null), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Message("Ok", false, incidenceRepository.saveAndFlush(incidence)), HttpStatus.OK);
    }
}
