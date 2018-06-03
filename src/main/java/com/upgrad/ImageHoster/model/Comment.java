package com.upgrad.ImageHoster.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

@Entity
@Table(name = "Comment")
public class Comment implements Serializable {
    // These annotations auto-increments the id column for us whenever
    // a new Comment object is stored into the database
    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Text is a Postgres specific column type that allows you to save
    // text based data that will be longer than 256 characters
    @Column(columnDefinition="TEXT")
    private String description;

    @Column
    private LocalDate commentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Image_id")
    private Image image;



    public Comment() {
    }

    public Comment(String description) {
        this.description = description;
    }


    public int getCommentId() {
        return id;
    }

    public void setCommentId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getUploadDate() {
        return commentDate;
    }

    public void setUploadDate(LocalDate uploadDate) {
        this.commentDate = uploadDate;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}

