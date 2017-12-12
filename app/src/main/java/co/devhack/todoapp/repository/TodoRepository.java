package co.devhack.todoapp.repository;

import java.util.List;

import co.devhack.todoapp.domain.model.Todo;

/**
 * Created by Rodolhan on 9/12/2017.
 */

public interface TodoRepository {

    Long insert(Todo todo) throws Exception;

    void update(Todo todo);

    void delete(Todo todo);

    List<Todo> getAll() throws Exception;

}