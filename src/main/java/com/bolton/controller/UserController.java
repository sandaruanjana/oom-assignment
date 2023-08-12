package com.bolton.controller;

import com.bolton.exception.UserAlreadyExistsException;
import com.bolton.exception.UserNotFoundException;
import com.bolton.model.Post;
import com.bolton.model.User;
import com.bolton.service.ServiceFactory;
import com.bolton.service.UserService;
import com.bolton.service.impl.UserServiceImpl;
import com.bolton.view.HomeView;

import java.util.List;

/**
 * @author Sandaru Anjana <sandaruanjana@outlook.com>
 */
public class UserController implements SuperController {
    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService;

    public UserController() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        userService = (UserService) serviceFactory.getService(ServiceFactory.ServiceType.USER);
    }

    public UserService getUserService() {
        return userService;
    }

    public User login(String email, String password) throws UserNotFoundException {
        User user = userService.login(email, password);
        if (user == null) {
            throw new UserNotFoundException("User not found for the given credentials.");
        }
        return user;

    }

    public boolean register(String name, String email, String password) throws UserAlreadyExistsException {
        boolean success = userService.register(name, email, password);
        if (!success) {
            throw new UserAlreadyExistsException("User with the same email already exists.");
        }
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
