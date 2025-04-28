package com.blogapi.blogapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String blogCategory;
    private String description;
    private String image;
    private String metaDescription;
    private String metaKeywords;
    private String metaTitle;
    private String paragraph;
    private String slug;
    private String tags;
    private String title;
}
