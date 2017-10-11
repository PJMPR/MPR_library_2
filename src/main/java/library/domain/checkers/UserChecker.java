package library.domain.checkers;

import library.domain.User;

public class UserChecker {
    public boolean validUserLogin(User user){
        return user.getLogin() != null && user.getLogin().isEmpty();
    }

    public boolean validUserPassword(User user){
        return user.getPassword() != null && user.getPassword().isEmpty();
    }
}
