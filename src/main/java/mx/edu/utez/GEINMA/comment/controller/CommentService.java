package mx.edu.utez.GEINMA.comment.controller;

import mx.edu.utez.GEINMA.comment.model.Comment;
import mx.edu.utez.GEINMA.comment.model.CommentRepository;
import mx.edu.utez.GEINMA.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@Transactional
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Message>findAll(){
        return new ResponseEntity<>(new Message("Ok", false, commentRepository.findAll()), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message>save(Comment comment){
        return new ResponseEntity<>(new Message("Ok", false, commentRepository.saveAndFlush(comment)), HttpStatus.OK);
    }
}
