package com.blogapi.blogapi.service;

import com.blogapi.blogapi.model.Blog;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

public interface BlogService {
    List<Blog> getAllBlogs();
    Blog getBlogById(Long id);
    Blog createBlog(String title,
                String slug,
                String blogCategory,
                String description,
                String metaTitle,
                String metaDescription,
                String metaKeywords,
                String tags,
                String paragraph,
                MultipartFile imageFile);

    Blog updateBlog(Long id, String title, String slug, String description,
                String blogCategory, String metaTitle, String metaDescription,
                String metaKeywords, String tags, String paragraph,
                MultipartFile imageFile) throws IOException;


void deleteBlog(Long id);
}
    