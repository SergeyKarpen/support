package com.omertex.support.service;

import com.omertex.support.model.Topic;
import com.omertex.support.model.User;

import java.util.List;

public interface TopicService extends GenericService<Topic, Long>{

    Topic findById(Long id);

    List<Topic> findAll();

    void deletedById(Long id);

    Topic save (Topic topic);

    List<Topic> findAllTopicByUserId(Long id);

    void deletedTopicsByUserIdIsNull();

    void queryTopById (Long id, String info);

}
