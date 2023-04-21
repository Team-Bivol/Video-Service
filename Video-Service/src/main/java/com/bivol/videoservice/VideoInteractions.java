package com.bivol.videoservice;

import java.util.Map;
import java.util.Set;

public class VideoInteractions {
    private Set<Integer> likes; //Ids of users, who liked the post
    private Map<Integer, Comment> comments; //user id -> comment text

    public VideoInteractions(Set<Integer> likes, Map<Integer, Comment> comments) {
        this.likes = likes;
        this.comments = comments;
    }

    public Set<Integer> getLikes() {
        return likes;
    }

    public void setLikes(Set<Integer> likes) {
        this.likes = likes;
    }

    public Map<Integer, Comment> getComments() {
        return comments;
    }

    public void setComments(Map<Integer, Comment> comments) {
        this.comments = comments;
    }
}
