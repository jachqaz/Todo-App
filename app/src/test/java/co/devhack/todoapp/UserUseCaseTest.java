package co.devhack.todoapp;

import junit.framework.Assert;

import org.junit.Test;

import co.devhack.todoapp.domain.usecase.UserUseCase;
import co.devhack.todoapp.domain.usecase.impl.UserUseCaseImpl;

/**
 * Created by Rodolhan on 12/12/2017.
 */

public class UserUseCaseTest {
    @Test
    public void isValidLoginAndPasswordSuccess() {
        UserUseCase userUseCase = new UserUseCaseImpl();
        boolean result = userUseCase.isValidLoginAndPassword("a@g.com", "123");
        Assert.assertTrue(result);
    }

    @Test
    public void isValidLoginAndPasswordError() {
        UserUseCase userUseCase = new UserUseCaseImpl();
        boolean result = userUseCase.isValidLoginAndPassword("a@g.com", null);
        Assert.assertFalse(result);
    }
}
