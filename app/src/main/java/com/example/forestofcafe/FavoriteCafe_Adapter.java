package com.example.forestofcafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FavoriteCafe_Adapter extends RecyclerView.Adapter<FavoriteCafe_Adapter.ViewHolder> {
    private ArrayList<FavoriteCafe_Item> data = null;
    FavoriteCafe_Adapter.OnItemClickListener fcListner;
    Context context;

    public FavoriteCafe_Adapter(ArrayList<FavoriteCafe_Item> list) {
        data = list;
    }


    public FavoriteCafe_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
        context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_holder_favorite_cafe,parent,false);
        FavoriteCafe_Adapter.ViewHolder vh = new FavoriteCafe_Adapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteCafe_Adapter.ViewHolder holder, int position) {

        FavoriteCafe_Item item = data.get(position);
        holder.cafe_image.setImageDrawable(item.getCafe_image());
        holder.cafe_name.setText(item.getCafe_name());
        holder.cafe_location.setText(item.getCafe_location());
        holder.cafe_number.setText(item.getCafe_number());
        holder.cafe_notice.setText(item.getCafe_notice());
        holder.cafe_open_close.setText(item.getCafe_open_close());
    }


    @Override
    public int getItemCount(){

        return  data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView cafe_name, cafe_location, cafe_number, cafe_notice, cafe_open_close;
        private ImageView cafe_image;
        private ImageButton favoriteBtn;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            cafe_image=itemView.findViewById(R.id.cafe_image);
            cafe_name = itemView.findViewById(R.id.cafe_name);
            cafe_location = itemView.findViewById(R.id.cafe_location);
            cafe_number = itemView.findViewById(R.id.cafe_number);
            cafe_notice= itemView.findViewById(R.id.cafe_notice);
            cafe_open_close = itemView.findViewById(R.id.cafe_open);
            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        FavoriteCafe_Item item = data.get(pos);
                        if(fcListner != null){
                            fcListner.onItemClick(v,pos);
                        }
                    }
                }
            });
        }
    }
    public interface OnItemClickListener{
        void onItemClick(View v, int pos);
    }

    public void setOnItemClickListener(FavoriteCafe_Adapter.OnItemClickListener listener){
        fcListner = listener;
    }
}