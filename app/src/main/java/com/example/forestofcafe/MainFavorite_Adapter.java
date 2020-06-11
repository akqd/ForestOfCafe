package com.example.forestofcafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainFavorite_Adapter extends RecyclerView.Adapter<MainFavorite_Adapter.ViewHolder> {
    private ArrayList<MainFavorite_Item> data = null;
    MainFavorite_Adapter.OnItemClickListener fListner;

    public MainFavorite_Adapter(ArrayList<MainFavorite_Item> list) {

        data = list;
    }


    public MainFavorite_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){

        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_holder_main_favorite,parent,false);
        MainFavorite_Adapter.ViewHolder vh = new MainFavorite_Adapter.ViewHolder(view);
        return vh;

    }


    @Override
    public void onBindViewHolder(@NonNull MainFavorite_Adapter.ViewHolder holder, int position) {

        MainFavorite_Item item = data.get(position);
        holder.cafe_image.setImageDrawable(item.getCafe_image());
        holder.cafe_name.setText(item.getCafe_name());
        holder.cafe_notice.setText(item.getCafe_notice());
        holder.cafe_open_close.setText(item.getCafe_open_close());

    }

    @Override
    public int getItemCount(){

        return  data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView cafe_name, cafe_notice, cafe_open_close;
        private ImageView cafe_image;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            cafe_image=itemView.findViewById(R.id.cafe_image);
            cafe_name = itemView.findViewById(R.id.cafe_name);
            cafe_notice= itemView.findViewById(R.id.cafe_notice);
            cafe_open_close = itemView.findViewById(R.id.cafe_open);

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        MainFavorite_Item item = data.get(pos);
                        if(fListner != null){
                            fListner.onItemClick(v,pos);
                        }
                    }
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClick(View v, int pos);
    }

    public void setOnItemClickListener(MainFavorite_Adapter.OnItemClickListener listener){
        fListner = listener;


    }
}