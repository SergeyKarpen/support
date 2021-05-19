package com.omertex.support.service.impl;

import com.omertex.support.model.User;
import com.omertex.support.repository.UserRepository;
import com.omertex.support.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        log.info("IN save() {} add", user.getFirstName());
        userRepository.save(user);
        return user;
    }

    @Override
    public boolean existsUserById(Long id) {
        return userRepository.existsUserById(id);
    }

    @Override
    public User findById(Long id) {
        log.info("IN findById() {}", "OK");
        return userRepository.findUserById(id);
    }

    @Override
    public List<User> findAll() {
        log.info("IN findAll {}", "OK");
        return userRepository.findAll();
    }

    @Override
    public void deletedById(Long id) {
        log.info("IN deletedById {} deleted user with id:", id);
        userRepository.deleteById(id);
    }
}

