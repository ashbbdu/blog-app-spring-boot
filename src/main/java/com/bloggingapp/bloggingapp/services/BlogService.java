package com.bloggingapp.bloggingapp.services;

import com.bloggingapp.bloggingapp.dtos.BlogDTO;
import com.bloggingapp.bloggingapp.entities.BlogEntity;
import com.bloggingapp.bloggingapp.repositories.BlogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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


    public void addBlog (BlogDTO blog) {
        BlogEntity newBlog = modelMapper.map(blog , BlogEntity.class);
        blogRepository.save(newBlog);
    }

    public List<BlogDTO> getBlogs() {
        List<BlogEntity> blogs = blogRepository.findAll();
        return blogs.stream().map(e -> modelMapper.map(e , BlogDTO.class)).collect(Collectors.toList());
    }
}
