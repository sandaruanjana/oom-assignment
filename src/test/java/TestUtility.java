import com.bolton.controller.ControllerFactory;
import com.bolton.controller.UserController;
import com.bolton.model.User;

/**
 * @author Sandaru Anjana <sandaruanjana@outlook.com>
 */
public class TestUtility {
    private static ControllerFactory controllerFactory = ControllerFactory.getInstance();

    public static UserController getUserController() {
        return (UserController) controllerFactory.getController(ControllerFactory.ControllerType.USER);
    }

    public static User registerUser(String name, String email, String password) {
        UserController userController = getUserController();
        boolean register = userController.register(name, email, password);
        if (register) {
            // User registration successful, return the registered user
            return userController.findUserByEmail(email);
        }
        return null; // Registration failed, return null
    }
}
