package com.bolton.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Sandaru Anjana <sandaruanjana@outlook.com>
 */
public class User {
    private String id = UUID.randomUUID().toString().replace("-", "");
    private String name;
    private String email;
    private String password;
    List<User> following = new ArrayList<>();
    List<Post> posts = new ArrayList<>();

    public User() {
    }

    public User(String id, String name, String email, String password, List<User> following, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.following = following;
        this.posts = posts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
