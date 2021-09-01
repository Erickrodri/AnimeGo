package com.dap.animego.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dap.animego.R;
import com.dap.animego.retrofit.response.Anime;
import com.dap.animego.ui.View.PictureDetailActivity;
import com.dap.animego.model.Picture;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder>{

    private List<Anime> pictures;
    private int resource;
    private Activity activity;

    public PictureAdapterRecyclerView(List<Anime> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PictureViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(resource, viewGroup, false);
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PictureViewHolder pictureViewHolder, int i) {
        Anime anime = pictures.get(i);

        final String id = anime.getId();

        pictureViewHolder.titleCard.setText(anime.getName());
        //pictureViewHolder.chapterCard.setText(anime.ge());
        Picasso.with(activity).load(anime.getImageUrl()).into(pictureViewHolder.pictureCard);

        pictureViewHolder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, PictureDetailActivity.class);

                intent.putExtra("idCard", id);

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(intent, ActivityOptionsCompat
                                                    .makeSceneTransitionAnimation(activity, view, activity.getString(R.string.transitionname_picture))
                                                    .toBundle());
                }else {
                    activity.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder{

        private ImageView pictureCard;
        private TextView titleCard;
        private TextView chapterCard;

        public PictureViewHolder(@NonNull View itemView) {
            super(itemView);

            pictureCard = itemView.findViewById(R.id.pictureCard);
            titleCard   = itemView.findViewById(R.id.titleCard);
            chapterCard = itemView.findViewById(R.id.chapterCard);
        }
    }
}
