package co.devhack.todoapp.presentation.presenter;

/**
 * Created by Rodolhan on 30/11/2017.
 */

public interface AuthContract {
    //Interface que implementara el Fragment o Activity
    interface View {
        void goToLoginfragmente();

        void goToMainActivity();
    }

    //Interfacr que implementara el presenter
    interface UserActionsLister {
        void gotToFirstFragment();
    }
}
