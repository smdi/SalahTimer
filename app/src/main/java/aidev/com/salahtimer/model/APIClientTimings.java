package aidev.com.salahtimer.model;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClientTimings {

    static Retrofit retrofit = null;

    public static Retrofit getClient(){

        if(retrofit  == null){

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.aladhan.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

            return retrofit;
        }
        return retrofit;
    }
}
