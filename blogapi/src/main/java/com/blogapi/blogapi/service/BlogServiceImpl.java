package com.blogapi.blogapi.service;

import com.blogapi.blogapi.model.Blog;
import com.blogapi.blogapi.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public Blog getBlogById(Long id) {
        Optional<Blog> blog = blogRepository.findById(id);
        return blog.orElse(null);
    }

    @Override
    public Blog createBlog(String title, String slug, String blogCategory, String description,
                           String metaTitle, String metaDescription, String metaKeywords,
                           String tags, String paragraph, MultipartFile imageFile) {
        
        Blog newBlog = new Blog();
        newBlog.setTitle(title);
        newBlog.setSlug(slug);
        newBlog.setBlogCategory(blogCategory);
        newBlog.setDescription(description);
        newBlog.setMetaTitle(metaTitle);
        newBlog.setMetaDescription(metaDescription);
        newBlog.setMetaKeywords(metaKeywords);
        newBlog.setTags(tags);
        newBlog.setParagraph(paragraph);

        if (imageFile != null && !imageFile.isEmpty()) {
            try {
                newBlog.setImage(imageFile.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return blogRepository.save(newBlog);
    }

    @Override
    public Blog updateBlog(Long id, String title, String slug, String description,
                           String blogCategory, String metaTitle, String metaDescription,
                           String metaKeywords, String tags, String paragraph,
                           MultipartFile imageFile) throws IOException {

        Blog existingBlog = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found"));

        existingBlog.setTitle(title);
        existingBlog.setSlug(slug);
        existingBlog.setDescription(description);
        existingBlog.setBlogCategory(blogCategory);
        existingBlog.setMetaTitle(metaTitle);
        existingBlog.setMetaDescription(metaDescription);
        existingBlog.setMetaKeywords(metaKeywords);
        existingBlog.setTags(tags);
        existingBlog.setParagraph(paragraph);

        if (imageFile != null && !imageFile.isEmpty()) {
            existingBlog.setImage(imageFile.getBytes());
        }

        return blogRepository.save(existingBlog);
    }

    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
