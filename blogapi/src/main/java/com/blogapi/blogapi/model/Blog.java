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

    private String title;
    private String slug;
    private String blogCategory;
    private String description;
    private String metaTitle;
    private String metaDescription;
    private String metaKeywords;
    private String tags;

    @Column(length = 10000)  // To support long blog content
    private String paragraph;

    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;

    // Optional getter/setter if you want to customize manually
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
