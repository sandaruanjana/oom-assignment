import com.bolton.controller.UserController;
import com.bolton.model.User;
import com.bolton.service.impl.UserServiceImpl;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest {
    public static final String TEST_EMAIL = "test@gmail.com";
    public static final String TEST_NAME = "test";
    public static final String TEST_PASSWORD = "123456";
    private static User registeredUser;

    @BeforeAll
    static void setUp() {
        // Register a user before each test method
        registeredUser = TestUtility.registerUser(TEST_NAME, TEST_EMAIL, TEST_PASSWORD);
        Assertions.assertNotNull(registeredUser);
    }

    @Test
    @DisplayName("Login With Valid Credentials")
    @Order(1)
    void login() {
        UserController userController = TestUtility.getUserController();
        User login = userController.login("test@gmail.com", "123456");
        Assertions.assertNotNull(login);
    }

    @Test
    @DisplayName("Invalid Login - Wrong Password")
    @Order(2)
    void invalidLoginWrongPassword() {
        UserController userController = TestUtility.getUserController();
        User login = userController.login("test@gmail.com", "wrongpassword");
        Assertions.assertNull(login); // Expecting null as login should fail with wrong password
    }

    @Test
    @DisplayName("Invalid Login - Non-Existing User")
    @Order(3)
    void invalidLoginNonExistingUser() {
        UserController userController = TestUtility.getUserController();
        User login = userController.login("nonexisting@gmail.com", "123456");
        Assertions.assertNull(login); // Expecting null as login should fail with non-existing user
    }

    @Test
    @DisplayName("Logout Test Case")
    @Order(4)
    void logout() {
        UserController userController = TestUtility.getUserController();
        User login = userController.login("test@gmail.com", "123456");
        Assertions.assertNotNull(login);

        // Now, test logout functionality
        userController.logout();
        Assertions.assertNull(UserServiceImpl.currentUser); // Expecting null as the user should be logged out
    }
}
