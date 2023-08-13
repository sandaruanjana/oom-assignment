package com.bolton.service;

import com.bolton.model.Post;

/**
 * @author Sandaru Anjana <sandaruanjana@outlook.com>
 */
public interface Subject<T> {
    void registerObserver(Observer<T> observer);
    void unregisterObserver(Observer<T> observer);
    void notifyObservers(T data);
}
