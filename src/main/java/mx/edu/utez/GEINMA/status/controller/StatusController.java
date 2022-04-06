package mx.edu.utez.GEINMA.status.controller;


import mx.edu.utez.GEINMA.status.model.Status;
import mx.edu.utez.GEINMA.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/status")
@CrossOrigin(origins = {"*"})
public class StatusController {
    @Autowired
    StatusService statusService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){return statusService.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<Message>getById(@PathVariable("id") long id){return statusService.findById(id);}

    @PostMapping("/")
    public ResponseEntity<Message>saveStatus(@RequestBody StatusDTO statusDTO){
        return statusService.save(new Status(statusDTO.getDescription()));
    }

    @PutMapping("/")
    public ResponseEntity<Message>update(@RequestBody Status statusDTO){
        return statusService.update(new Status(statusDTO.getId(), statusDTO.getDescription()));
    }
}
