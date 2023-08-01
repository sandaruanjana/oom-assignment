package com.bolton.model;

import java.util.UUID;

/**
 * @author Sandaru Anjana <sandaruanjana@outlook.com>
 */
public class Post {
    private String id = UUID.randomUUID().toString().replace("-", "");
    private String content;
    private User user;

    public Post() {
    }

    public Post(String id, String content, User user) {
        this.id = id;
        this.content = content;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
