package com.blogapi.blogapi.controller;

import com.blogapi.blogapi.model.Blog;
import com.blogapi.blogapi.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;  // blogService ko inject kiya

    @GetMapping
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs(); // Service ka use karte hue
    }

    @GetMapping("/blog/{id}")
    public Blog getBlog(@PathVariable Long id) {
        return blogService.getBlogById(id); // Service ka use karte hue
    }

    @PostMapping
    public Blog createBlog(@RequestBody Blog blog) {
        return blogService.createBlog(blog); // Service ka use karte hue
    }

    @PutMapping("/{id}")
    public Blog updateBlog(@PathVariable Long id, @RequestBody Blog updatedBlog) {
        return blogService.updateBlog(id, updatedBlog); // Service ka use karte hue
    }

    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id); // Service ka use karte hue
    }
}
