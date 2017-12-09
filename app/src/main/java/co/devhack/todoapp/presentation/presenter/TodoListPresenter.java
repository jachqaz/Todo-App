package co.devhack.todoapp.presentation.presenter;

import java.util.ArrayList;
import java.util.List;

import co.devhack.todoapp.domain.model.Todo;
import co.devhack.todoapp.domain.usecase.TodoUseCase;
import co.devhack.todoapp.domain.usecase.impl.TodoUseCaseImpl;
import co.devhack.todoapp.helpers.Callback;

/**
 * Created by Rodolhan on 9/12/2017.
 */

public class TodoListPresenter implements TodoListContract.UserActionsListener {

    private TodoListContract.View view;
    private TodoUseCase todoUseCase;
    private List<Todo> lstTodos;

    public TodoListPresenter(TodoListContract.View view) {
        this.view = view;
        this.todoUseCase = new TodoUseCaseImpl();
        this.lstTodos = new ArrayList<>(0);
    }

    @Override
    public void loadAll() {
        todoUseCase.getAll(new Callback<List<Todo>>() {
            @Override
            public void success(List<Todo> result) {
                //Se hace clear sobre la instancia del lstTodos para evitar que el TodoAdapter quede
                //con una referencia vieja de los datos cuando se actualicen
                lstTodos.clear();
                lstTodos.addAll(result);
            }

            @Override
            public void error(Exception error) {
                //TODO MOSTRAR ERROR
                //view.showErrorMessage(error);
            }
        });
    }

    @Override
    public List<Todo> getLstTodos() {
        return lstTodos;
    }
}