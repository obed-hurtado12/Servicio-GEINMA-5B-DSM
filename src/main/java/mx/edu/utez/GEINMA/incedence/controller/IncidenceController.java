package mx.edu.utez.GEINMA.incedence.controller;

import mx.edu.utez.GEINMA.incedence.model.Incidence;
import mx.edu.utez.GEINMA.security.jwt.JwtProvider;
import mx.edu.utez.GEINMA.user.controller.UserService;
import mx.edu.utez.GEINMA.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


@RestController
@RequestMapping("/incidence")
@CrossOrigin(origins = {"*"})
public class IncidenceController {
    SimpleDateFormat formato = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy", new Locale("es_ES"));
    @Autowired
    IncidenceService incidenceService;
    @Autowired
    UserService userService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){return incidenceService.findAll();}

    @GetMapping("/client/{client}")
    public ResponseEntity<Message> getByClient(@PathVariable("client") long id){
        return incidenceService.findAllByClient(id);
    }

    @GetMapping("/technical/{technical}")
    public ResponseEntity<Message> getByTechnical(@PathVariable("technical") long id){
        return incidenceService.findAllByTechnical(id);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<Message> getByStatus(@PathVariable("status") long id){
        return incidenceService.findAllByStatus(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id){
        return incidenceService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> save(@RequestBody IncidenceDTO incidenceDTO){
        return incidenceService.save(new Incidence(incidenceDTO.getDescription(), formato.format(new Date()), userService.getByEmail(incidenceDTO.getToken()).get(), incidenceDTO.getTechnical(), incidenceDTO.getStatus(), incidenceDTO.getExperience(), incidenceDTO.getPictureIncidence()));
    }

    @PutMapping("/")
    public ResponseEntity<Message> update(@RequestBody IncidenceDTO incidenceDTO){
        return incidenceService.save(new Incidence(incidenceDTO.getId(), incidenceDTO.getDescription(), formato.format(new Date()), incidenceDTO.getClient(), incidenceDTO.getTechnical(), incidenceDTO.getStatus(), incidenceDTO.getExperience(), incidenceDTO.getPictureIncidence()));
    }


}
