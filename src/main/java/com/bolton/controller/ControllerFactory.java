package com.bolton.controller;

/**
 * @author Sandaru Anjana <sandaruanjana@outlook.com>
 */
public class ControllerFactory {
    private static ControllerFactory controllerFactory;

    private ControllerFactory(){

    }

    public static ControllerFactory getInstance(){
        if (controllerFactory == null) {
            controllerFactory = new ControllerFactory();
        }
        return controllerFactory;
    }

    public enum ControllerType{
        USER
    }

    public SuperController getController(ControllerType controllerType){
        switch(controllerType){
            case USER:
                return new UserController();
            default:
                return null;
        }
    }
}
