package com.example.lenovo.l_retorfit3;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.net.URL;

public class RetorfitUtil {

    public static void resquestGet(Callback<String> callback) {
        String BASE_URL = "http://10.0.2.2/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<String> call = apiService.requestGet("Get");
        call.enqueue(callback);
    }

    public static void requestPost(Callback<String> callback) {
        String BASE_URL = "http://10.0.2.2";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<String> call = apiService.requestPost("post");
        call.enqueue(callback);
    }
}
