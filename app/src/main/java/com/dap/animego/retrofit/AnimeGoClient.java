package com.dap.animego.retrofit;

import com.dap.animego.common.Constantes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnimeGoClient {
    private static AnimeGoClient instance = null;
    private AnimeGoService animeGoService;
    private Retrofit retrofit;

    public AnimeGoClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.API_ANIMEGO_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        animeGoService = retrofit.create(AnimeGoService.class);
    }

    // Patron Singleton
    public static AnimeGoClient getInstance(){
        if(instance == null){
            instance = new AnimeGoClient();
        }
        return instance;
    }

    public AnimeGoService getAnimeGoService(){
        return animeGoService;
    }
}
