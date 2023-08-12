import com.bolton.controller.UserController;
import com.bolton.exception.UserNotFoundException;
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
        registeredUser = TestUtility.registerUser(TEST_NAME, TEST_EMAIL, TEST_PASSWORD);
        Assertions.assertNotNull(registeredUser);
    }

    @Test
    @DisplayName("Login With Valid Credentials")
    @Order(1)
    void login() {
        UserController userController = TestUtility.getUserController();
        try {
            User login = userController.login(TEST_EMAIL, TEST_PASSWORD);
            Assertions.assertNotNull(login);
        } catch (UserNotFoundException e) {
            Assertions.fail("User should be found with valid credentials.");
        }
    }

    @Test
    @DisplayName("Invalid Login - Wrong Password")
    @Order(2)
    void invalidLoginWrongPassword() {
        UserController userController = TestUtility.getUserController();
        try {
           userController.login(TEST_EMAIL, "wrongpassword");
           Assertions.fail("Login should fail with wrong password.");
        } catch (UserNotFoundException e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    @DisplayName("Invalid Login - Non-Existing User")
    @Order(3)
    void invalidLoginNonExistingUser() {
        UserController userController = TestUtility.getUserController();
        try {
            userController.login("nonexisting@gmail.com", TEST_PASSWORD);
            Assertions.fail("Login should fail with non-existing user.");
        } catch (UserNotFoundException e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    @DisplayName("Logout Test Case")
    @Order(4)
    void logout() {
        UserController userController = TestUtility.getUserController();
        User login = null;
        try {
            login = userController.login(TEST_EMAIL, TEST_PASSWORD);
        } catch (UserNotFoundException e) {
            Assertions.fail("User should be found with valid credentials.");
        }
        Assertions.assertNotNull(login);

        userController.logout();
        Assertions.assertNull(UserServiceImpl.currentUser);
    }
}
