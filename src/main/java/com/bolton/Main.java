package com.bolton;

import com.bolton.controller.ControllerFactory;
import com.bolton.controller.UserController;
import com.bolton.model.User;
import com.bolton.service.impl.UserServiceImpl;
import com.bolton.view.HomeView;
import com.bolton.view.LoginForm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sandaru Anjana <sandaruanjana@outlook.com>
 */
public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();

        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();

        user1.setName("Sandaru Anjana");
        user1.setEmail("sandaru@gmail.com");
        user1.setPassword("123456");

        user2.setName("Kasun Kalhara");
        user2.setEmail("kasun@gmail.com");
        user2.setPassword("123456");

        user3.setName("Sachin Lakshitha");
        user3.setEmail("sachin@gmail.com");
        user3.setPassword("123456");

        user4.setName("Chamodhi Nisansala");
        user4.setEmail("chamoi@gmail.com");
        user4.setPassword("123456");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        ControllerFactory controllerFactory = ControllerFactory.getInstance();

        UserController userController = (UserController) controllerFactory.getController(ControllerFactory.ControllerType.USER);

        for (User user : users) {
            userController.register(user.getName(), user.getEmail(), user.getPassword());
        }

        if (UserServiceImpl.currentUser == null) {
            new LoginForm().setVisible(true);
        } else {
            new HomeView().setVisible(true);
        }
    }
}
