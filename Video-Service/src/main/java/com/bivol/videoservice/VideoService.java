package com.bivol.videoservice;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VideoService {

    private VideoRepository videoRepository;
    @Autowired
    private HttpSession session;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Video saveVideo(Video video) {
        video.setUploaderEmail(getUserEmailFromSession());
        return videoRepository.save(video);
    }

    public Video getVideoById(Long id) {
        try {
            Optional<Video> optionalVideo = videoRepository.findById(id);
            return optionalVideo.orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error getting video by id: " + id, e);
        }
    }

    public String getUserEmailFromSession() {
        return (String) session.getAttribute("userEmail");
    }
    public String getUserInterestsFromSession() {
        return (String) session.getAttribute("userInterests");
    }

    public Comment addComment(Long videoId, Comment comment){
        return this.getVideoById(videoId).addComment(comment);
    }

    public Long addLike(Video video, Long userId){
        return(video.addLike(userId));
    }

    public Comment removeComment(Video video, Comment comment){
        return video.removeComment(comment);
    }

    public Long removeLike(Video video, Long userId){
        return(video.removeLike(userId));
    }
    public List<Video> getVideosByTags(List<String> tags) {
        return videoRepository.findAllByTagsIn(tags);
    }

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }
}
