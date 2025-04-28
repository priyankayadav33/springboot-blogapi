package com.blogapi.blogapi.controller;

import com.blogapi.blogapi.model.Blog;
import com.blogapi.blogapi.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    // ✅ Get all blogs
    @GetMapping
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    // ✅ Get single blog by ID
    @GetMapping("/{id}")
    public Blog getBlog(@PathVariable Long id) {
        return blogService.getBlogById(id);
    }

    // ✅ Create blog (fixed path)
    @PostMapping
    public ResponseEntity<Blog> createBlog(
            @RequestParam String title,
            @RequestParam String slug,
            @RequestParam String blogCategory,
            @RequestParam String description,
            @RequestParam String metaTitle,
            @RequestParam String metaDescription,
            @RequestParam String metaKeywords,
            @RequestParam String tags,
            @RequestParam String paragraph,
            @RequestParam MultipartFile image
    ) {
        Blog newBlog = blogService.createBlog(
                title, slug, blogCategory, description,
                metaTitle, metaDescription, metaKeywords,
                tags, paragraph, image
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(newBlog);
    }

    // ✅ Update blog with image (PUT)
    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Blog updateBlog(
            @PathVariable Long id,
            @RequestParam("title") String title,
            @RequestParam("slug") String slug,
            @RequestParam("description") String description,
            @RequestParam("blogCategory") String blogCategory,
            @RequestParam("metaTitle") String metaTitle,
            @RequestParam("metaDescription") String metaDescription,
            @RequestParam("metaKeywords") String metaKeywords,
            @RequestParam("tags") String tags,
            @RequestParam("paragraph") String paragraph,
            @RequestParam(value = "image", required = false) MultipartFile imageFile
    ) throws IOException {
        return blogService.updateBlog(
                id, title, slug, description,
                blogCategory, metaTitle, metaDescription,
                metaKeywords, tags, paragraph, imageFile
        );
    }

    // ✅ Delete blog
    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
    }
}
