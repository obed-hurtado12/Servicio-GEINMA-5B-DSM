package mx.edu.utez.GEINMA.experience.controller;

import mx.edu.utez.GEINMA.experience.model.Experience;
import mx.edu.utez.GEINMA.experience.model.ExperienceRepository;
import mx.edu.utez.GEINMA.role.model.Role;
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
public class ExperienceService {
    @Autowired
    ExperienceRepository experienceRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("OK", false, experienceRepository.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message>findById(long id){
        if (experienceRepository.existsById(id)){
            return new ResponseEntity<>(new Message("Ok", false, experienceRepository.findById(id)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("No se encontró", true, null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message>save(Experience experience){
        Experience savedExperience = experienceRepository.saveAndFlush(experience);
        return new ResponseEntity<>(new Message("OK", false, savedExperience), HttpStatus.OK);
    }


}
