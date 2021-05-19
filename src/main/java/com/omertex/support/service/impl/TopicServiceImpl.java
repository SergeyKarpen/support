package com.omertex.support.service.impl;

import com.omertex.support.model.Topic;
import com.omertex.support.repository.TopicRepository;
import com.omertex.support.service.TopicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public Topic findById(Long id) {
        log.info("IN findById() {}", "OK");
        return topicRepository.findTopicById(id);
    }

    @Override
    public List<Topic> findAll() {
        log.info("IN findAll {}", "OK");
        return topicRepository.findAll();
    }

    @Override
    public void deletedById(Long id) {
        log.info("IN deletedById {} deleted user with id:", id);
        topicRepository.deleteById(id);
    }

    @Override
    public Topic save(Topic topic) {
        log.info("IN save() {} add", topic.getId());
        topic.setCreated(new Date());
        return topicRepository.save(topic);
    }

    @Override
    public List<Topic> findAllTopicByUserId(Long id) {
        log.info("IN findAllTopicByUserId() {}", "OK");
        return topicRepository.findAllByUOrderByUser_id(id);
    }

    @Override
    public void deletedTopicsByUserIdIsNull() {
        log.info("IN deletedTopicsByUserIdIsNull() {}", "OK");
        topicRepository.deleteTopicsByUser_idIsNull();
    }

    @Override
    public void queryTopById(Long id, String info) {
        log.info("IN queryTopById() {}", "OK");
        topicRepository.queryTopById(id, info);
    }
}
