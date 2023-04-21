package com.bivol.videoservice;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoManagementService {

    private final VideoRepository videoRepository;
    private final KafkaTemplate<String, VideoInteractions> videoInteractionsKafkaTemplate;

    public VideoManagementService(VideoRepository videoRepository,
                                  KafkaTemplate<String, VideoInteractions> videoInteractionsKafkaTemplate) {
        this.videoRepository = videoRepository;
        this.videoInteractionsKafkaTemplate = videoInteractionsKafkaTemplate;
    }

    public Video uploadVideo(Video video) {
        // TODO: Implement video upload functionality
        return videoRepository.save(video);
    }

    public Video getVideoById(Long id) {
        Optional<Video> video = videoRepository.findById(id);
        return video.orElse(null);
    }

    public List<Video> searchVideosByTags(List<String> tags) {
        // TODO: Implement video search functionality based on tags
        return videoRepository.findAllByTagsIn(tags);
    }

    @KafkaListener(topics = "video-interactions-topic", groupId = "my-group")
    public void consumeVideoInteractions(VideoInteractions videoInteractions) {
        // TODO: Update video data based on new interactions
        videoRepository.updateVideoInteractions(videoInteractions);
        // TODO: Send message to Notifications Service to determine which users should receive notifications
        videoInteractionsKafkaTemplate.send("notifications-topic", videoInteractions);
    }

}
