package co.devhack.todoapp.repository;

import java.io.IOException;
import java.util.List;

import co.devhack.todoapp.domain.model.Todo;

/**
 * Created by Rodolhan on 9/12/2017.
 */

public interface TodoRepository {

    Long insert(Todo todo) throws Exception;

    void update(Todo todo) throws Exception;

    void delete(Todo todo) throws IOException;

    List<Todo> getAll() throws Exception;

}