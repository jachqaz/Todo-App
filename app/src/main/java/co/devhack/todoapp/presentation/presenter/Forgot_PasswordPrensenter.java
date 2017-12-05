package co.devhack.todoapp.presentation.presenter;

import co.devhack.todoapp.domain.usecase.UserUseCase;
import co.devhack.todoapp.domain.usecase.impl.UserUseCaseImpl;
import co.devhack.todoapp.helpers.Callback;

/**
 * Created by Rodolhan on 5/12/2017.
 */

public class Forgot_PasswordPrensenter implements Forgot_PasswordContract.UserActionsListener {
    private Forgot_PasswordContract.View view;
    private UserUseCase userUseCase;

    public Forgot_PasswordPrensenter(Forgot_PasswordContract.View view) {
        this.view = view;
        this.userUseCase = new UserUseCaseImpl();
    }

    @Override
    public void onForgot(String email) {
        userUseCase.forgotPassword(email, new Callback<Boolean>() {
            @Override
            public void success(Boolean result) {
                view.showSuccessMessage();
            }

            @Override
            public void error(Exception error) {
                view.showErrorMessage(error);
            }
        });
    }
}
