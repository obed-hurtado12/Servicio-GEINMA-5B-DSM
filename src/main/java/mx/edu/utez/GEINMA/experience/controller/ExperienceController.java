package mx.edu.utez.GEINMA.experience.controller;

import mx.edu.utez.GEINMA.experience.model.Experience;
import mx.edu.utez.GEINMA.role.controller.RoleDTO;
import mx.edu.utez.GEINMA.role.model.Role;
import mx.edu.utez.GEINMA.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/experience")
@CrossOrigin(origins = {"*"})
public class ExperienceController {
    @Autowired
    ExperienceService experienceService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){return experienceService.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<Message>getById(@PathVariable("id") long id){return experienceService.findById(id);}

    @PostMapping("/")
    public ResponseEntity<Message>save(@RequestBody ExperienceDTO experienceDTO){
        return experienceService.save(new Experience(experienceDTO.getDescription(), experienceDTO.getScore()));
    }
}
