package com.dap.animego.ui.View;

import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dap.animego.R;
import com.dap.animego.common.MyApp;
import com.dap.animego.retrofit.AnimeGoClient;
import com.dap.animego.retrofit.AnimeGoService;
import com.dap.animego.retrofit.response.AnimeId;
import com.dap.animego.retrofit.response.Chapter;
import com.dap.animego.retrofit.response.Season;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PictureDetailActivity extends AppCompatActivity {
    AnimeGoClient animeGoClient;
    AnimeGoService animeGoService;
    ImageView imageViewHeader;
    TextView textViewTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detail);
        showToolbar("",false);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            getWindow().setEnterTransition(new Fade());
        }

        retrofitInit();
        imageViewHeader = findViewById(R.id.imageHeader);
        textViewTitle   = findViewById(R.id.titleDetail);

        String idCard =getIntent().getExtras().getString("idCard");

        Call<AnimeId> call = animeGoService.doAnimeId(idCard);
        call.enqueue(new Callback<AnimeId>() {
            @Override
            public void onResponse(Call<AnimeId> call, Response<AnimeId> response) {
                if(response.isSuccessful()){

                    List<Season> chapterList = response.body().getSeason();
                    Picasso.with(MyApp.getContext()).load(response.body().getImageUrl()).into(imageViewHeader);
                    textViewTitle.setText(response.body().getName());

                    Log.i("datos",response.body().getSeason()+"");
                }
            }

            @Override
            public void onFailure(Call<AnimeId> call, Throwable t) {
                Toast.makeText(PictureDetailActivity.this, "Error de conexion", Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void retrofitInit() {
        animeGoClient = AnimeGoClient.getInstance();
        animeGoService = animeGoClient.getAnimeGoService();
    }

    public void showToolbar(String title, boolean upButton){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingToolbar);
    }
}
