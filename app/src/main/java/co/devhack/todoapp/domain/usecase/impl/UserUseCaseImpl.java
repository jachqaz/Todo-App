package co.devhack.todoapp.domain.usecase.impl;

import co.devhack.todoapp.domain.model.User;
import co.devhack.todoapp.domain.usecase.UserUseCase;
import co.devhack.todoapp.helpers.Callback;
import co.devhack.todoapp.repository.UserRepository;
import co.devhack.todoapp.repository.impl.UserFirebaseRepository;

/**
 * Created by Rodolhan on 2/12/2017.
 */

public class UserUseCaseImpl implements UserUseCase {
    private UserRepository userRepository;

    public UserUseCaseImpl() {
        this.userRepository = new UserFirebaseRepository();
    }

    @Override
    public void login(String email, String password, final boolean remember, final Callback<User> callback) {
        userRepository.login(email, password, new Callback<User>() {
            @Override
            public void success(User user) {
                //Todo guarardar Email en sharedpreferences
                if (user != null && remember) {

                }
                callback.success(user);
            }

            @Override
            public void error(Exception error) {
                callback.error(error);
            }
        });
    }

    @Override
    public void signUp(String fullName, String email, String password, final Callback<User> callback) {
        User user = new User(fullName, email, password);
        userRepository.signUp(user, new Callback<User>() {
            @Override
            public void success(User user) {
                callback.success(user);
            }

            @Override
            public void error(Exception error) {
                callback.error(error);
            }
        });
    }
}
