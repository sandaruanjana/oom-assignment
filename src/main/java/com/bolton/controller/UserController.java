package com.bolton.controller;

import com.bolton.model.Post;
import com.bolton.model.User;
import com.bolton.service.ServiceFactory;
import com.bolton.service.UserService;
import com.bolton.service.impl.UserServiceImpl;

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
        return userService.register(name, email, password);
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

    public boolean follow(String email) {
       return userService.follow(email);
    }

    public boolean unfollow(String email) {
        return userService.unfollow(email);
    }

    public User findUserByEmail(String email) {
        return userService.findUserByEmail(email);
    }

    public User getCurrentUser() {
        return UserServiceImpl.currentUser;
    }

    public void setCurrentUser(User user) {
        UserServiceImpl.currentUser = user;
    }

}
