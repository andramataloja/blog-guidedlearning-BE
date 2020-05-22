package com.nortal.summeruni.blog.service;

import com.nortal.summeruni.blog.entity.BlogPost;
import com.nortal.summeruni.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    public List<BlogPost> getPosts() {
        return blogRepository.findAll();
    }

    public BlogPost getPost(Long id) {
        return blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog with specified id was not found"));
    }

    public Long addPost(BlogPost post) {
        return blogRepository.save(post).getId();
    }

    public Long updatePost(Long id, BlogPost post) {
        return blogRepository.save(post).getId();
    }

    public ResponseEntity<HttpStatus> deletePost(Long id) {
        try {
            blogRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }
}
