package com.bivol.videoservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, CommentId> {
    @Query("SELECT c FROM Comment c JOIN c.id id WHERE id.userId = :userId")
    List<Comment> findByUserId(@Param("userId") Long userId);
}