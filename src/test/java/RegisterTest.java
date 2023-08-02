import com.bolton.model.User;
import org.junit.jupiter.api.*;

public class RegisterTest {
    public static final String TEST_EMAIL = "abc@gmail.com";
    public static final String TEST_NAME = "abc";
    public static final String TEST_PASSWORD = "123456";
    private static User registeredUser;

    @BeforeAll
    static void setUp() {
        // Register a user once before all test methods
        registeredUser = TestUtility.registerUser(TEST_NAME, TEST_EMAIL, TEST_PASSWORD);
        Assertions.assertNotNull(registeredUser);
    }

    @Test
    @DisplayName("Register Test Case")
    void register() {
        // User is already registered in the setup, so this test should pass
        Assertions.assertNotNull(registeredUser);
    }

    @Test
    @DisplayName("Registration with Existing Email")
    void registrationWithExistingEmail() {
        // Try to register another user with the same email
        User duplicateUser = TestUtility.registerUser(TEST_NAME, TEST_EMAIL, TEST_PASSWORD);
        Assertions.assertNull(duplicateUser); // Expecting null as registration should fail due to an existing email
    }
}
