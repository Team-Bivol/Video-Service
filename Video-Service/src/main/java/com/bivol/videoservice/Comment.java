package com.bivol.videoservice;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {

    @EmbeddedId
    private CommentId id;
    private String commentText;
    private LocalDateTime uploadTime;

    public Comment() {}

    public Comment(Long userId, String commentText) {
        this.id = new CommentId(userId);
        this.commentText = commentText;
        this.uploadTime = LocalDateTime.now();
    }

    public CommentId getId() {
        return id;
    }

    public void setId(CommentId id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public LocalDateTime getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(LocalDateTime uploadTime) {
        this.uploadTime = uploadTime;
    }
}
