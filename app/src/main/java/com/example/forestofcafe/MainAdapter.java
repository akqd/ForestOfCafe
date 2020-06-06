package com.example.forestofcafe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {
    private String[] Cafe_name, Cafe_distance, Cafe_openclose;
    private Integer[] Cafe_images;

    MainHolder mainHolder;

    public MainAdapter(String[] Cafe_name, String[] Cafe_distance, String[] Cafe_openclose, Integer[] Cafe_images) {
        this.Cafe_name = Cafe_name;
        this.Cafe_distance = Cafe_distance;
        this.Cafe_openclose = Cafe_openclose;
        this.Cafe_images = Cafe_images;
    }

    public static class MainHolder extends RecyclerView.ViewHolder {

        public TextView Cafe_name, Cafe_distance, Cafe_openclose;
        public ImageView Cafe_images;

        public MainHolder(View view) {
            super(view);
            this.Cafe_name = view.findViewById(R.id.tvCafeName);
            this.Cafe_distance = view.findViewById(R.id.tvCafeDistance);
            this.Cafe_openclose = view.findViewById(R.id.tvCafeOpenClose);
            this.Cafe_images = view.findViewById(R.id.imgMainCafe1);
        }
    }

    @NonNull
    @Override

    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View holderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_main_cafelist, parent, false);
        mainHolder = new MainHolder(holderView);
        return mainHolder;

    }


    @Override

    public void onBindViewHolder(@NonNull MainHolder mainHolder, int i) {

        mainHolder.Cafe_name.setText(this.Cafe_name[i]);
        mainHolder.Cafe_distance.setText(this.Cafe_distance[i]);
        mainHolder.Cafe_openclose.setText(this.Cafe_openclose[i]);
        mainHolder.Cafe_images.setImageResource(this.Cafe_images[i]);

    }


    @Override

    public int getItemCount() {
        return Cafe_name.length;
    }
}
