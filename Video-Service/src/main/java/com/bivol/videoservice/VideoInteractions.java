package com.bivol.videoservice;

import java.time.LocalDateTime;

;

public class VideoInteractions {
    private Long uploaderId;
    private String uploaderEmail;
    private Long interactorId;
    private String interactorName;
    private Long commentId;
    private Long videoId;
    private String text;
    private LocalDateTime timeCreated;

    public VideoInteractions(Long uploaderId, String uploaderEmail, String interactorName, Long interactorId,
                             Long commentId, Long videoId, String text, LocalDateTime timeCreated) {
        this.uploaderId = uploaderId;
        this.uploaderEmail = uploaderEmail;
        this.interactorId = interactorId;
        this.interactorName = interactorName;
        this.commentId = commentId;
        this.videoId = videoId;
        this.text = text;
        this.timeCreated = timeCreated;
    }

    public Long getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(Long uploaderId) {
        this.uploaderId = uploaderId;
    }

    public String getUploaderEmail() {
        return uploaderEmail;
    }

    public void setUploaderEmail(String uploaderEmail) {
        this.uploaderEmail = uploaderEmail;
    }

    public String getInteractorName() {
        return interactorName;
    }

    public void setInteractorName(String interactorName) {
        this.interactorName = interactorName;
    }

    public Long getInteractorId() {
        return interactorId;
    }

    public void setInteractorId(Long interactorId) {
        this.interactorId = interactorId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
