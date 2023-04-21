package com.bivol.videoservice;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "videos")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String url;

    @ElementCollection
    private List<String> tags;

    @ElementCollection
    private Set<Long> likes;

    @OneToMany
    private List<Comment> comments;

    public Video() {
    }

    public Video(Long id, String title, String description, String url, List<String> tags, Set<Long> likes, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
        this.tags = tags;
        this.likes = likes;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Set<Long> getLikes() {
        return likes;
    }

    public void setLikes(Set<Long> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Comment addComment(Comment comment){
        this.comments.add(comment);
        return comment;
    }

    public Long addLike(Long userId){
        this.likes.add(userId);
        return userId;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
