package co.devhack.todoapp;

import android.app.Application;

import co.devhack.todoapp.database.AppDatabase;

/**
 * Created by Rodolhan on 8/12/2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        AppDatabase.init(getApplicationContext());
    }
}