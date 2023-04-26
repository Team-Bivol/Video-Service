package com.bivol.videoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {

    private final VideoService videoService;
    private final VideoInteractionsProducer producer;

    @Autowired
    public VideoController(VideoService videoService, VideoInteractionsProducer producer) {
        this.videoService = videoService;
        this.producer = producer;
    }


    @PostMapping
    public ResponseEntity<Video> uploadVideo(@RequestBody Video video) {
        Video savedVideo = videoService.saveVideo(video);
        return new ResponseEntity<>(savedVideo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable Long id) {
        Video video = videoService.getVideoById(id);
        if (video == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(video, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Video>> getAllVideos() {
        List<Video> videos = videoService.getAllVideos();
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Video>> getVideosByTags(@RequestParam List<String> tags) {
        List<Video> videos = videoService.getVideosByTags(tags);
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }

    @PostMapping("/{id}/comments")
    public ResponseEntity<Comment> addComment(@PathVariable Long id,
                                              @RequestBody Comment comment) {
//        Comment comment = new Comment(userId, commentText);
        Comment savedComment = videoService.addComment(id, comment);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/likes")
    public ResponseEntity<Long> addLike(@PathVariable Long id, @RequestBody Long userId) {
        Video video = videoService.getVideoById(id);
        String email = videoService.getUserEmailFromSession();
        if (video == null) {
            return new ResponseEntity<Long>(HttpStatus.NOT_FOUND);
        }
        Long savedLike = videoService.addLike(video, userId);
        producer.sendVideoInteractions(email);
        return new ResponseEntity<Long>(savedLike, HttpStatus.CREATED);
    }

}
