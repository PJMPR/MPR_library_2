package library.domain.checkers;


import library.domain.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserCheckerTest {

    @Test
    public void test_user_checker_should_check_user_login(){

        UserChecker checker = new UserChecker();

        User userWithLogin = new User();
        userWithLogin.setLogin("a");
        User userWithNullLogin = new User();
        User userWithEmptyStringLogin = new User();
        userWithEmptyStringLogin.setLogin("");

        boolean isActorValid = checker.validUserLogin(userWithLogin);
        boolean isActorWithNullNameValid = checker.validUserLogin(userWithNullLogin);
        boolean isActorWithEmptyStringNameValid = checker.validUserLogin(userWithEmptyStringLogin);

        assertTrue("User with login should be a valid user", isActorValid);
        assertFalse("User with null login should be invalid", isActorWithNullNameValid);
        assertFalse("User with empty string login should be invalid", isActorWithEmptyStringNameValid);


    }

    @Test
    public void test_user_checker_should_check_user_password(){

        UserChecker checker = new UserChecker();

        User userWithPassword = new User();
        userWithPassword.setPassword("a");
        User userWithNullPassword = new User();
        User userWithEmptyStringPassword = new User();
        userWithEmptyStringPassword.setPassword("");

        boolean isActorValid = checker.validUserPassword(userWithPassword);
        boolean isActorWithNullNameValid = checker.validUserPassword(userWithNullPassword);
        boolean isActorWithEmptyStringNameValid = checker.validUserPassword(userWithEmptyStringPassword);

        assertTrue("User with password should be a valid user", isActorValid);
        assertFalse("User with null password should be invalid", isActorWithNullNameValid);
        assertFalse("User with empty string password should be invalid", isActorWithEmptyStringNameValid);
    }
}
