package com.bivol.videoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoManagementService {

    private final VideoRepository videoRepository;
    private final VideoService videoService;
    private final VideoInteractionsProducer videoInteractionsProducer;

    @Autowired
    public VideoManagementService(VideoRepository videoRepository, VideoService videoService, VideoInteractionsProducer videoInteractionsProducer) {
        this.videoRepository = videoRepository;
        this.videoService = videoService;
        this.videoInteractionsProducer = videoInteractionsProducer;
    }

    public Video uploadVideo(Video video) {
        return videoRepository.save(video);
    }

    public Video getVideoById(Long id) {
        Optional<Video> video = videoRepository.findById(id);
        return video.orElse(null);
    }

    public List<Video> searchVideosByTags(List<String> tags) {
        return videoRepository.findAllByTagsIn(tags);
    }

}