package com.bivol.videoservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findAllByTagsIn(List<String> tags);

    @Modifying
    @Query("UPDATE Video v SET v.likes = :#{#videoInteractions.likes}, v.comments = :#{#videoInteractions.comments} WHERE v.id = :#{#videoInteractions.videoId}")
    void updateVideoInteractions(VideoInteractions videoInteractions);

}

