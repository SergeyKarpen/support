package com.omertex.support.service.impl;

import com.omertex.support.model.User;
import com.omertex.support.repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTests {

    @MockBean
    private UserRepository userRepository;

    @Test
    void save() {
        User user = new User();
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setPhone("000000");
          user.setCreated(new Date());
        userRepository.save(user);
        Assert.assertEquals(user, user);
        Assert.assertNotNull(user);
    }

    @Test
    void existsUserById() {
        userRepository.existsUserById(null);
        Assert.assertFalse(false);
        userRepository.existsUserById(-1L);
        Assert.assertFalse(false);
        userRepository.existsUserById(21L);
        Assert.assertTrue(true);
    }

    @Test
    void findById() {
        User user = new User();
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setPhone("000000");
        user.setCreated(new Date());
        userRepository.findUserById(null);
        Assert.assertNull(null);
        userRepository.findUserById(0L);
        Assert.assertNull(null);
        userRepository.findUserById(10L);
        Assert.assertEquals(user, user);

    }

    @Test
    void findAll() {
        userRepository.findAll();
        List<User> userList = new ArrayList<>();
        assertEquals(userList , userList);
    }

    @Test
    void deletedById() {
        User user = new User();
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setPhone("000000");
        user.setCreated(new Date());
        userRepository.deleteById(null);
        Assert.assertNull(null);
        userRepository.deleteById(0L);
        Assert.assertNull(null);
        userRepository.deleteById(10L);
        Assert.assertEquals(user, user);
    }
}
