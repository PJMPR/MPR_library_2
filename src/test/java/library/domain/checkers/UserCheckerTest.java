package library.domain.checkers;


import library.domain.User;
import static org.junit.Assert.*;

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
        User userWithNotLongEnoughLoginValid = new User();
        userWithNotLongEnoughLoginValid.setLogin("to");
        User userWithValidLoginLength = new User();
        userWithValidLoginLength.setLogin("tomasz");

        boolean isActorValid = checker.validUserLogin(userWithLogin);
        boolean isActorWithNullLoginValid = checker.validUserLogin(userWithNullLogin);
        boolean isActorWithEmptyStringLoginValid = checker.validUserLogin(userWithEmptyStringLogin);
        boolean isActorWithNotLongEnoughLoginValid = checker.validUserLoginLength(userWithNotLongEnoughLoginValid);
        boolean isActorWithValidLoginLength = checker.validUserLoginLength(userWithValidLoginLength);

        assertTrue("User with login should be a valid user", isActorValid);
        assertFalse("User with null login should be invalid", isActorWithNullLoginValid);
        assertFalse("User with empty string login should be invalid", isActorWithEmptyStringLoginValid);
        assertFalse("User with login longer then 2 and shorter than 32 chars login should be invalid", isActorWithNotLongEnoughLoginValid);
        assertTrue("User with login longer then 2 and shorter than 32 chars should be a valid user", isActorWithValidLoginLength);
    }

    @Test
    public void test_user_checker_should_check_user_password(){

        UserChecker checker = new UserChecker();

        User userWithPassword = new User();
        userWithPassword.setPassword("a");
        User userWithNullPassword = new User();
        User userWithEmptyStringPassword = new User();
        userWithEmptyStringPassword.setPassword("");

        User userWithPasswordWithNoCapitalLetter = new User();
        userWithPasswordWithNoCapitalLetter.setPassword("password9");
        User userWithPasswordWithNoNumber = new User();
        userWithPasswordWithNoNumber.setPassword("Password");
        User userWithPasswordWithNotEnoughCharacters = new User();
        userWithPasswordWithNotEnoughCharacters.setPassword("Pa9");
        User userWithPasswordCorrect = new User();
        userWithPasswordCorrect.setPassword("aA1234");


        boolean isActorValid = checker.validUserPassword(userWithPassword);
        boolean isActorWithNullPasswordValid = checker.validUserPassword(userWithNullPassword);
        boolean isActorWithEmptyStringPasswordValid = checker.validUserPassword(userWithEmptyStringPassword);

        boolean isActorWithNoCapitalLetterPasswordValid = checker.validUserPasswordFormat(userWithPasswordWithNoCapitalLetter);
        boolean isActorWithNoNumberInPasswordValid = checker.validUserPasswordFormat(userWithPasswordWithNoNumber);
        boolean isActorWithNotEnoughCharactersInPasswordValid = checker.validUserPasswordFormat(userWithPasswordWithNotEnoughCharacters);
        boolean isActorWithCorrectPasswordValid = checker.validUserPasswordFormat(userWithPasswordCorrect);

        assertTrue("User with password should be a valid user", isActorValid);
        assertFalse("User with null password should be invalid", isActorWithNullPasswordValid);
        assertFalse("User with empty string password should be invalid", isActorWithEmptyStringPasswordValid);

        assertFalse("User with password with no capital letter should be invalid", isActorWithNoCapitalLetterPasswordValid);
        assertFalse("User with password with no number should be invalid", isActorWithNoNumberInPasswordValid);
        assertFalse("User with not enough characters in password should be invalid", isActorWithNotEnoughCharactersInPasswordValid);
        assertTrue("User with every condition right should be a valid user", isActorWithCorrectPasswordValid);
    }
}
