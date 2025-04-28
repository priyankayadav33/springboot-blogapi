package com.blogapi.blogapi.repository;

import com.blogapi.blogapi.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
