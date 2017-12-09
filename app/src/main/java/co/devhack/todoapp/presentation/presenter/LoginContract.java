package co.devhack.todoapp.presentation.presenter;

/**
 * Created by Rodolhan on 30/11/2017.
 */

public interface LoginContract {
    interface View {
        void goToSignUpFragment();

        void goToMainActivity();

        void showMessageError(Exception error);

        void showProgress();

        void hideProgress();
    }

    interface UserActionsListener {
        void onLogin(String email, String password, boolean remember);
    }
}
