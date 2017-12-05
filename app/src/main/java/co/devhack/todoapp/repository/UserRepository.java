package co.devhack.todoapp.repository;

import co.devhack.todoapp.domain.model.User;
import co.devhack.todoapp.helpers.Callback;

/**
 * Created by Rodolhan on 30/11/2017.
 */

public interface UserRepository {
    void login(String email, String password, Callback<User> callback);

    void signUp(User user, Callback<User> callback);

    void forgotPassword(String email, Callback<Boolean> callback);
}
