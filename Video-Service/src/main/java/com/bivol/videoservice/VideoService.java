package com.bivol.videoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VideoService {

    private VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Video saveVideo(Video video) {
        return videoRepository.save(video);
    }

    public Video getVideoById(Long id) {
        return videoRepository.findById(id).orElse(null);
    }

    public Comment addComment(Video video, Comment comment){
        return video.addComment(comment);
    }

    public Long addLike(Video video, Long userId){
        return(video.addLike(userId));
    }
    public List<Video> getVideosByTags(List<String> tags) {
        return videoRepository.findAllByTagsIn(tags);
    }

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }
}
