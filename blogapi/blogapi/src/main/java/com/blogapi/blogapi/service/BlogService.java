package com.blogapi.blogapi.service;

import com.blogapi.blogapi.model.Blog;
import java.util.List;
import java.util.Optional;

public interface BlogService {
    List<Blog> getAllBlogs();
    Blog getBlogById(Long id);
    Blog createBlog(Blog blog);
    Blog updateBlog(Long id, Blog updatedBlog);
    void deleteBlog(Long id);
}
