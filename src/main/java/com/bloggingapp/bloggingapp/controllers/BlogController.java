package com.bloggingapp.bloggingapp.controllers;

import com.bloggingapp.bloggingapp.dtos.BlogDTO;
import com.bloggingapp.bloggingapp.services.BlogService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/blog")
public class BlogController {

    private final BlogService blogService;

    public BlogController (BlogService blogService) {
        this.blogService = blogService;
    }


    @GetMapping
    public List<BlogDTO> getBlogs () {
        return blogService.getBlogs();
    }

    @PostMapping()
    public void addBlog (@RequestBody @Valid BlogDTO blog) {
        blogService.addBlog(blog);
    }

    @GetMapping(path = "/{blogId}")
    public ResponseEntity<BlogDTO> getBlogById (@PathVariable Long blogId) {
        BlogDTO blog = blogService.getBlogById(blogId);
//        if(blog == null) {
//            return new ResponseEntity<>(blog , HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(blog , HttpStatus.OK);

        //will be adding global exception

        if (blog == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(blog);
    }


    @PutMapping("/{blogId}")
    public ResponseEntity<BlogDTO> updateBlog (@PathVariable Long blogId , @RequestBody @Valid BlogDTO blogData) {
        BlogDTO blog = blogService.updateBlog(blogId , blogData);
        if (blog == null) {
            return ResponseEntity.notFound().build();
//            return new ResponseEntity<>(HttpStatus.OK);
        }

        return ResponseEntity.ok(blog);
//        return new ResponseEntity<>(blog , HttpStatus.NOT_FOUND);
    }
}
