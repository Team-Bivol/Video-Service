package com.bivol.videoservice;



public class VideoInteractions {
    private String uploaderEmail;
    private String state;

    public VideoInteractions(String uploaderEmail, String state) {
        this.uploaderEmail = uploaderEmail;
        this.state = state; // LIKE or COMMENT
    }

    public String getUploaderEmail() {
        return uploaderEmail;
    }

    public void setUploaderEmail(String uploaderEmail) {
        this.uploaderEmail = uploaderEmail;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
