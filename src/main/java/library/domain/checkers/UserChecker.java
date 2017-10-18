package library.domain.checkers;

import library.domain.User;

import java.util.regex.Pattern;

public class UserChecker {
    public boolean validUserLogin(User user){
        return user.getLogin() != null && !(user.getLogin().isEmpty());
    }

    public boolean validUserLoginLength(User user){
        return user.getLogin().length() > 2 && user.getLogin().length() < 17;
    }

    public boolean validUserPassword(User user){
        return user.getPassword() != null && !(user.getPassword().isEmpty());
    }

    public boolean validUserPasswordFormat(User user){
        String rx1 = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,16}";
        return user.getPassword().matches(rx1);
    }
}
