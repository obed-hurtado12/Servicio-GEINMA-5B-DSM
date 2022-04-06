package mx.edu.utez.GEINMA.role.controller;

import mx.edu.utez.GEINMA.role.model.Role;
import mx.edu.utez.GEINMA.role.model.RoleRepository;
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
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Message>findAll(){
        return new ResponseEntity<>(new Message("OK", false, roleRepository.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message>findById(long id){
        if (roleRepository.existsById(id)){
            return new ResponseEntity<>(new Message("Ok", false, roleRepository.findById(id)), HttpStatus.OK);
        }
            return new ResponseEntity<>(new Message("No se encontró", true, null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message>save(Role role){
        Optional<Role> existRole = roleRepository.findByDescription(role.getDescription());
        if (existRole.isPresent()){
            return new ResponseEntity<>(new Message("Ya existe el rol", true, null), HttpStatus.BAD_REQUEST);
        }
        Role savedRole = roleRepository.saveAndFlush(role);
        return new ResponseEntity<>(new Message("OK", false, savedRole), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message>update(Role role){
        if (roleRepository.existsById(role.getId())){
            return new ResponseEntity<>(new Message("Ok", false, roleRepository.saveAndFlush(role)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("No existe el rol", true, null),HttpStatus.BAD_REQUEST);
    }
}
