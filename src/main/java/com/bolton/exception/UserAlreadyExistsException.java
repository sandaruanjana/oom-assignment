package com.bolton.exception;

/**
 * @author Sandaru Anjana <sandaruanjana@outlook.com>
 */
public class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
