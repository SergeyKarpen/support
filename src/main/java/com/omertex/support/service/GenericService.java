package com.omertex.support.service;

import com.omertex.support.model.User;

import java.util.List;

public interface GenericService <T, ID> {

    T findById(ID id);

    List<T> findAll();

    void deletedById(ID id);

    T save (T t);
}
