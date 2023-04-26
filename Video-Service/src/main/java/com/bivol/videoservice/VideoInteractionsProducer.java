package com.bivol.videoservice;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoInteractionsProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public VideoInteractionsProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendVideoInteractions(String userEmail) {
        kafkaTemplate.send("video-interactions-topic", userEmail);
    }
}
