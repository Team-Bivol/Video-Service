package com.bivol.videoservice;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CommentId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long commentId;

    private Long userId;

    public CommentId() {}

    public CommentId(Long commentId, Long userId) {
        this.commentId = commentId;
        this.userId = userId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // Implement equals() and hashCode() methods
}
