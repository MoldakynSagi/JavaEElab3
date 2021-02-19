package kz.java;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private final List<user> store = new ArrayList<>();

    public boolean add(final user user) {

        for (user u : store) {
            if (u.getLogin().equals(user.getLogin()) && u.getPassword().equals(user.getPassword())) {
                return false;
            }
        }

        return store.add(user);
    }

    public user.NAME getRoleByLoginPassword(final String login, final String password) {
        user.NAME result = user.NAME.UNK;

        for (user user : store) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = user.getName();
            }
        }

        return result;
    }

    public boolean userIsExist(final String login, final String password) {

        boolean result = false;

        for (user user : store) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = true;
                break;
            }
        }

        return result;
    }
}
