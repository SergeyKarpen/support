package com.omertex.support.controller;


import com.omertex.support.model.Status;
import com.omertex.support.model.Topic;
import com.omertex.support.model.User;
import com.omertex.support.service.TopicService;
import com.omertex.support.service.UserService;
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
@RequestMapping("api/users/")
public class UserController {

    private final UserService userService;
    private final TopicService topicService;

    @Autowired
    public UserController(UserService userService, TopicService topicService) {
        this.userService = userService;
        this.topicService = topicService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<User> result = new ArrayList<>();
        result.addAll(users);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @GetMapping(value = "{id}")
    public ResponseEntity<User> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(value = "save")
    public ResponseEntity<User> save(@RequestBody @Validated User user) {
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        user.setStatus(Status.ACTIVE);
        user.setCreated(new Date());
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping(value = "update")
    public ResponseEntity<User> update(@RequestBody @Validated User user) {
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User result = userService.findById(user.getId());
        result.setCreated(new Date());
        result.setPhone(user.getPhone());
        result.setLastName(user.getLastName());
        result.setFirstName(user.getFirstName());
        result.setStatus(Status.ACTIVE);
        userService.save(result);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @Transactional
    @DeleteMapping(value = "deleted/{id}")
    public ResponseEntity<Void> deletedById(@PathVariable Long id) {
        if (userService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else userService.deletedById(id);
        topicService.deletedTopicsByUserIdIsNull();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
