package com.bloggingapp.bloggingapp.repositories;

import com.bloggingapp.bloggingapp.entities.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component // will make this a bean
public interface BlogRepository extends JpaRepository<BlogEntity , Long> {
}
