import com.bolton.controller.UserController;
import com.bolton.model.User;
import org.junit.jupiter.api.*;

public class UserFunctionalityTest {
    private static User registeredUser1;
    private static User registeredUser2;
    private UserController userController;
    private User currentUser;

    @BeforeAll
    static void setUp() {
        // Register users before running any test methods
        registeredUser1 = TestUtility.registerUser("user1", "user1@gmail.com", "password1");
        registeredUser2 = TestUtility.registerUser("user2", "user2@gmail.com", "password2");
        Assertions.assertNotNull(registeredUser1);
        Assertions.assertNotNull(registeredUser2);
    }

    @BeforeEach
    void loginAndSetUpCurrentUser() {
        userController = TestUtility.getUserController();
        currentUser = userController.login(registeredUser1.getEmail(), registeredUser1.getPassword());
        userController.setCurrentUser(currentUser);
    }

    @Test
    @DisplayName("User Follow Test")
    @Order(1)
    void userFollow() {
        // user1 follows user2
        boolean follow = userController.follow(registeredUser2.getEmail());
        Assertions.assertTrue(follow);
    }

    @Test
    @DisplayName("User Unfollow Test")
    @Order(2)
    void userUnfollow() {
        // user1 unfollows user2
        boolean unfollowResult = userController.unfollow(registeredUser2.getEmail());
        Assertions.assertTrue(unfollowResult);
    }


    @Test
    @DisplayName("User Post Test")
    @Order(3)
    void userPost() {
        // user1 posts a new post
        userController.post("This is a test post");
        Assertions.assertEquals(1, userController.getAllPosts().size());
    }

}
