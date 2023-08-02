package com.bolton.service.impl;

import com.bolton.model.Post;
import com.bolton.model.User;
import com.bolton.service.SuperService;
import com.bolton.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sandaru Anjana <sandaruanjana@outlook.com>
 */
public class UserServiceImpl implements UserService, SuperService {
    private static final List<User> users = new ArrayList<>();
    public static User currentUser = null;

    @Override
    public User login(String email, String password) {
        if (users.isEmpty()) {
            return null;
        }

        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public boolean register(String name, String email, String password) {

        // check if email already exists
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return false;
            }
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        users.add(user);
        return true;
    }

    @Override
    public boolean follow(String email) {

        User user = findUserByEmail(email);

        if (user == null) {
            return false;
        }

        // check if already following
        for (User following : currentUser.getFollowing()) {
            if (following.getEmail().equals(email)) {
                return false;
            }
        }

        currentUser.getFollowing().add(user);

        return true;
    }

    @Override
    public boolean unfollow(String email) {
        User user = findUserByEmail(email);

        if (user == null) {
            return false;
        }
        currentUser.getFollowing().remove(user);
        return true;
    }

    @Override
    public void post(String content) {
        Post post = new Post();
        post.setContent(content);
        post.setUser(currentUser);
        currentUser.getPosts().add(post);

    }

    @Override
    public User findUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public void logout() {
        currentUser = null;
    }

    @Override
    public List<Post> getPosts() {
        // return current user post and following user posts
        List<Post> posts = new ArrayList<>();
        posts.addAll(currentUser.getPosts());

        currentUser.getFollowing().forEach(user -> {
            posts.addAll(user.getPosts());
        });

        return posts;

    }

    @Override
    public List<User> getAllUsers() {

        // return all users except current user and following users
        List<User> allUsers = new ArrayList<>();
        allUsers.addAll(users);

        allUsers.remove(currentUser);

//        currentUser.getFollowing().forEach(user -> {
//            allUsers.remove(user);
//        });

        return allUsers;

    }
}
