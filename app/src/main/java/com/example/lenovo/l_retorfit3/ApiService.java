package com.example.lenovo.l_retorfit3;

import retrofit2.Call;
import retrofit2.http.*;

public interface ApiService {
    @GET("get.php")
    Call<String> requestGet(@Query("key") String key);

    @FormUrlEncoded
    @POST("post.php")
    Call<String> requestPost(@Field("key") String key);

    @GET("{url}")
    Call<String> getUrlString1(@Path("url") String url);
}
