package ru.startandroid.p0342tvseries;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList series_id, series_title, series_genre, series_seasons;

    CustomAdapter(Activity activity, Context context, ArrayList series_id, ArrayList series_title, ArrayList series_genre,
                  ArrayList series_seasons){
        this.activity = activity;
        this.context = context;
        this.series_id = series_id;
        this.series_title = series_title;
        this.series_genre = series_genre;
        this.series_seasons = series_seasons;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.series_id_txt.setText(String.valueOf(series_id.get(position)));
        holder.series_title_txt.setText(String.valueOf(series_title.get(position)));
        holder.series_genre_txt.setText(String.valueOf(series_genre.get(position)));
        holder.series_seasons_txt.setText(String.valueOf(series_seasons.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(series_id.get(position)));
                intent.putExtra("title", String.valueOf(series_title.get(position)));
                intent.putExtra("genre", String.valueOf(series_genre.get(position)));
                intent.putExtra("seasons", String.valueOf(series_seasons.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return series_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView series_id_txt, series_title_txt, series_genre_txt, series_seasons_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            series_id_txt = itemView.findViewById(R.id.series_id_txt);
            series_title_txt = itemView.findViewById(R.id.series_title_txt);
            series_genre_txt = itemView.findViewById(R.id.series_genre_txt);
            series_seasons_txt = itemView.findViewById(R.id.series_seasons_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }
    }
}
