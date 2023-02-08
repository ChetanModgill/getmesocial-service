package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.Comment;
import com.example.getmesocialservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentResource {

    @Autowired
    private CommentService commentService;

    //save Users
    @PostMapping
    public Comment saveComment(@RequestBody Comment comment)
    {
        return commentService.saveComment(comment);

    }
    @GetMapping
    public List<Comment> getAllcomments(){
        return commentService.getAllComments();
    }



    @GetMapping("/id")
    public List<Comment> getCommentById(@RequestParam(name = "id") String id)
    {
        return commentService.getCommentById(id);
    }

    @PutMapping
    public Comment updateComment(@RequestBody Comment comment)
    {
        return commentService.updateComment(comment);
    }

    @DeleteMapping
    public void deleteComment(@RequestParam(name = "id") String id)
    {
        commentService.deleteComment(id);
    }

}
