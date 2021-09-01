package com.dap.animego.ui.View.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dap.animego.R;
import com.dap.animego.adapter.PictureAdapterRecyclerView;
import com.dap.animego.model.Picture;
import com.dap.animego.retrofit.AnimeGoClient;
import com.dap.animego.retrofit.AnimeGoService;
import com.dap.animego.retrofit.response.Anime;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    List<Anime> animeList;
    AnimeGoService animeGoService;
    AnimeGoClient animeGoClient;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //Toolbar Home
        showToolbar(getResources().getString(R.string.bottom_home),false,view);

        //Retrofit
        retrofitInit();

        RecyclerView pictureRecycler = null;

        pictureRecycler = view.findViewById(R.id.pictureRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        pictureRecycler.setLayoutManager(linearLayoutManager);

        Call<List<Anime>> call = animeGoService.getAnimeAll();
        final RecyclerView finalPictureRecycler = pictureRecycler;
        call.enqueue(new Callback<List<Anime>>() {
            @Override
            public void onResponse(Call<List<Anime>> call, Response<List<Anime>> response) {
                if(response.isSuccessful()){
                    animeList = response.body();
                    List<Anime> nombreAnime = animeList;

                    PictureAdapterRecyclerView pictureAdapterRecyclerView = new PictureAdapterRecyclerView(nombreAnime,R.layout.cardview_picture, getActivity());

                    finalPictureRecycler.setAdapter(pictureAdapterRecyclerView);

                }else {

                }
            }

            @Override
            public void onFailure(Call<List<Anime>> call, Throwable t) {

            }
        });


        return view;
    }

    private void retrofitInit() {
        animeGoClient = AnimeGoClient.getInstance();
        animeGoService = animeGoClient.getAnimeGoService();
    }

    public ArrayList<Picture> buidPictures(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("https://i0.wp.com/www.sugoi.com.pe/wp-content/uploads/2019/02/domes.jpeg?w=840&ssl=1","Domestic na Kanojo","capitulos: 120"));
        pictures.add(new Picture("https://a.wattpad.com/cover/73097050-352-k73061.jpg","shigatsu wa kimi no uso","capitulos: 120"));
        pictures.add(new Picture("https://images-na.ssl-images-amazon.com/images/I/81pHjhE6GuL._SY445_.jpg","AnoHana","capitulos: 120"));
        pictures.add(new Picture("https://is3-ssl.mzstatic.com/image/thumb/Video/v4/cd/d5/ef/cdd5ef39-71c9-a7c3-05a2-e23a305a6849/mza_216071550077837512.jpg/268x0w.jpg","Bersek","capitulos: 120"));
        pictures.add(new Picture("https://images-na.ssl-images-amazon.com/images/I/81FQsgy7QiL._SY445_.jpg","GTO","capitulos: 120"));
        return pictures;
    }

    public void showToolbar(String title, boolean upButton, View view){
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
