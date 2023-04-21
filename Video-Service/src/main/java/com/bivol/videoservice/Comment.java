package com.bivol.videoservice;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @EmbeddedId
    private CommentId id;

    private String commentText;

    public Comment() {}

    public Comment(Long commentId, Long userId, String commentText) {
        this.id = new CommentId(commentId, userId);
        this.commentText = commentText;
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
}
