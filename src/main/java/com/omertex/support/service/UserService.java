package com.omertex.support.service;

import com.omertex.support.model.User;

import java.util.List;

public interface UserService extends GenericService<User, Long>{

    User findById(Long id);

    List<User> findAll();

    void deletedById(Long id);

    User save (User user);

    boolean existsUserById(Long id);
}
