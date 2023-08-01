package com.bolton.service;

import com.bolton.service.impl.UserServiceImpl;

/**
 * @author Sandaru Anjana <sandaruanjana@outlook.com>
 */
public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory(){

    }

    public static ServiceFactory getInstance(){
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }

    public enum ServiceType{
        USER
    }

    public SuperService getService(ServiceType serviceType){
        switch(serviceType){
            case USER:
                return new UserServiceImpl();
            default:
                return null;
        }
    }
}
