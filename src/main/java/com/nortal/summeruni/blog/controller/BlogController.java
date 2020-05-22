package com.nortal.summeruni.blog.controller;

import com.nortal.summeruni.blog.entity.BlogPost;
import com.nortal.summeruni.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class BlogController {
    private final BlogService blogService;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public List<BlogPost>getPosts(){
        return blogService.getPosts();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public BlogPost getPost(@PathVariable Long id) {
        return blogService.getPost(id);
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public Long addPost(@RequestBody BlogPost post) {
        return blogService.addPost(post);
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Long updatePost(@PathVariable Long id, @RequestBody BlogPost post) {
        return blogService.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<HttpStatus> deletePost(@PathVariable long id) {
       return blogService.deletePost(id);
    }

}
