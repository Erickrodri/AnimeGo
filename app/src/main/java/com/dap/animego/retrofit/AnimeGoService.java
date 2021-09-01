package com.dap.animego.retrofit;

import com.dap.animego.retrofit.request.RequestLogin;
import com.dap.animego.retrofit.request.RequestSingUp;
import com.dap.animego.retrofit.response.Anime;
import com.dap.animego.retrofit.response.AnimeId;
import com.dap.animego.retrofit.response.ResponseAuth;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AnimeGoService {

    @POST("login")
    Call<ResponseAuth> doLogin(@Body RequestLogin requestLogin);

    @POST("user")
    Call<ResponseAuth> doSingUp(@Body RequestSingUp requestSingUp);

    @GET("anime")
    Call<List<Anime>> getAnimeAll();

    @GET("anime/{id}")
    Call<AnimeId> doAnimeId(@Path("id") String idPost);
}
