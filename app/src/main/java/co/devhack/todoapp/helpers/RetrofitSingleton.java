package co.devhack.todoapp.helpers;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rodolhan on 12/12/2017.
 */

public class RetrofitSingleton {
    private static Retrofit retrofit;

    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = getInstance("https://test-1-600e1.firebaseio.com/");
        }

        return retrofit;
    }

    public static Retrofit getInstance(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
