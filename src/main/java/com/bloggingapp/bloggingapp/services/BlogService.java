package com.bloggingapp.bloggingapp.services;

import com.bloggingapp.bloggingapp.dtos.BlogDTO;
import com.bloggingapp.bloggingapp.entities.BlogEntity;
import com.bloggingapp.bloggingapp.repositories.BlogRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {

    public final BlogRepository blogRepository;
    public final ModelMapper modelMapper;

    public BlogService(BlogRepository blogRepository , ModelMapper modelMapper) {
        this.blogRepository = blogRepository;
        this.modelMapper = modelMapper;
    }

//    @Autowired
//    private ModelMapper modelMapper;


    public ResponseEntity<BlogDTO> addBlog (BlogDTO blog) {
        BlogEntity newBlog = modelMapper.map(blog , BlogEntity.class);

        BlogEntity savedBlog = blogRepository.save(newBlog);
        BlogDTO nb =  modelMapper.map(savedBlog , BlogDTO.class);
        return ResponseEntity.ok(nb);
    }

    public List<BlogDTO> getBlogs() {
        List<BlogEntity> blogs = blogRepository.findAll();
        return blogs.stream().map(e -> modelMapper.map(e , BlogDTO.class)).collect(Collectors.toList());
    }


    public BlogDTO getBlogById(Long blogId) {
        BlogEntity blog = blogRepository.findById(blogId).orElse(null);
        if(blog == null) {
            throw new IllegalArgumentException("Blog with this id does not exist");
        }
        return modelMapper.map(blog , BlogDTO.class);

    }

    public BlogDTO updateBlog(Long blogId, BlogDTO blogData) {
        BlogEntity blog = blogRepository.findById(blogId).orElse(null);
        if (blog == null) {
//            return null; // safe exit
            throw new IllegalArgumentException("Blog with this id does not exist");
        }

        blog.setFirst_name(blogData.getFirst_name());
        blog.setLast_name(blogData.getLast_name());
        blog.setPassword(blogData.getPassword());

        BlogEntity updatedBlog = blogRepository.save(blog);
        return modelMapper.map(updatedBlog , BlogDTO.class);
    }
}
