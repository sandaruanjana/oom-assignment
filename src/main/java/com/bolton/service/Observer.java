package com.bolton.service;

import com.bolton.model.Post;

/**
 * @author Sandaru Anjana <sandaruanjana@outlook.com>
 */
public interface Observer<T> {
    void update(T data);
}
