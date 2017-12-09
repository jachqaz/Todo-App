package co.devhack.todoapp.presentation.presenter;

/**
 * Created by Rodolhan on 9/12/2017.
 */

public class AddTodoPresenter implements AddTodoContract.UserActionsLister {
    private AddTodoContract.View view;

    public AddTodoPresenter(AddTodoContract.View view) {
        this.view = view;
    }
}
