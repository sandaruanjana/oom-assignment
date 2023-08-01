package com.bolton.controller;

import com.bolton.model.Post;
import com.bolton.model.User;
import com.bolton.service.ServiceFactory;
import com.bolton.service.UserService;

import java.util.List;

/**
 * @author Sandaru Anjana <sandaruanjana@outlook.com>
 */
public class UserController implements SuperController {
    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService = (UserService) serviceFactory.getService(ServiceFactory.ServiceType.USER);

    public User login(String email, String password) {
        return userService.login(email, password);
    }

    public boolean register(String name, String email, String password) {
        userService.register(name, email, password);
        return true;
    }

    public void logout() {
        userService.logout();
    }

    public void post(String content) {
        userService.post(content);
    }

    public List<Post> getAllPosts() {
        return userService.getPosts();
    }

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    public void follow(String email) {
        userService.follow(email);
    }

    public void unfollow(String email) {
        userService.unfollow(email);
    }

}
