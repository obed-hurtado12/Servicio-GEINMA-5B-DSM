package mx.edu.utez.GEINMA.role.controller;

import mx.edu.utez.GEINMA.role.model.Role;
import mx.edu.utez.GEINMA.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@CrossOrigin(origins = {"*"})
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){return roleService.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<Message>getById(@PathVariable("id") long id){return roleService.findById(id);}

    @PostMapping("/")
    public ResponseEntity<Message>saveRol(@RequestBody RoleDTO roleDTO){
        return roleService.save(new Role(roleDTO.getDescription()));
    }

    @PutMapping("/")
    public ResponseEntity<Message>update(@RequestBody RoleDTO roleDTO){
        return roleService.update(new Role(roleDTO.getId(), roleDTO.getDescription()));
    }
}
