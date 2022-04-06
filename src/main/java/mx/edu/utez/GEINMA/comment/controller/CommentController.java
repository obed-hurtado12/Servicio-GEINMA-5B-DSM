package mx.edu.utez.GEINMA.comment.controller;

import mx.edu.utez.GEINMA.comment.model.Comment;
import mx.edu.utez.GEINMA.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = {"*"})
public class CommentController {
    SimpleDateFormat formato = new SimpleDateFormat("dd MMM yyyy hh:mm:ss", new Locale("es_ES"));

    @Autowired
    CommentService commentService;

    @PostMapping("/")
    public ResponseEntity<Message>save(@RequestBody CommentDTO commentDTO){
        return commentService.save(new Comment(commentDTO.getDescription(), formato.format(new Date()), commentDTO.getUser(), commentDTO.getIncidence()));
    }
}
