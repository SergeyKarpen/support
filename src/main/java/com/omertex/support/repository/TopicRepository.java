package com.omertex.support.repository;

import com.omertex.support.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

    Topic findTopicById(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM topics WHERE user_id = ?1")
    List<Topic> findAllByUOrderByUser_id(Long id);

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM topics WHERE user_id IS NULL")
    void deleteTopicsByUser_idIsNull();

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE topics SET information = ?2 WHERE id= ?1")
    void queryTopById(Long id, String info);
}
