package com.omertex.support.controller;

import com.omertex.support.model.Status;
import com.omertex.support.model.Topic;
import com.omertex.support.model.User;
import com.omertex.support.repository.TopicRepository;
import com.omertex.support.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/topics/")
public class TopicController {

    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Topic>> getAll() {
        List<Topic> topics = topicService.findAll();
        if (topics.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<Topic> result = new ArrayList<>();
        result.addAll(topics);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Topic> getById(@PathVariable(name = "id") Long id) {
        Topic topic = topicService.findById(id);
        if (topic == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(topic, HttpStatus.OK);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<List<Topic>> findAllTopicsByUserId(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Topic> topics = topicService.findAllTopicByUserId(id);
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

    @PostMapping(value = "save")
    public ResponseEntity<Topic> save(@RequestBody @Validated Topic topic) {
        if (topic == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        topic.setCreated(new Date());
        topicService.save(topic);
        return new ResponseEntity<>(topic, HttpStatus.CREATED);
    }

    @Transactional
    @PutMapping(value = "update")
    public ResponseEntity<Topic> update(@RequestBody Topic topic) {

        if (topic == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        topic.setCreated(new Date());
        topic.setInformation(topic.getInformation());
        topicService.queryTopById(topic.getId(), topic.getInformation());
        return new ResponseEntity<>(topic, HttpStatus.CREATED);
    }
}
