package com.bloggingapp.bloggingapp.controllers;

import com.bloggingapp.bloggingapp.dtos.BlogDTO;
import com.bloggingapp.bloggingapp.services.BlogService;
import jakarta.validation.Valid;
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

}
