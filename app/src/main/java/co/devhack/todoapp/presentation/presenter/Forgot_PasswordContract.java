package co.devhack.todoapp.presentation.presenter;

/**
 * Created by Rodolhan on 5/12/2017.
 */

public interface Forgot_PasswordContract {
    interface View {
        void showErrorMessage(Exception error);

        void showSuccessMessage();
    }

    interface UserActionsListener {
        void onForgot(String email);
    }
}
