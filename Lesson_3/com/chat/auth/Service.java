package com.chat.auth;

import com.chat.entity.User;

import java.util.Collection;

public interface Service<T> {

    Collection<T> findAll();
    int save(T o);
}
