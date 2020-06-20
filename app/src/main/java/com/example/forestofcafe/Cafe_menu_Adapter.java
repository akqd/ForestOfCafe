package com.example.forestofcafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Cafe_menu_Adapter extends RecyclerView.Adapter<Cafe_menu_Adapter.ViewHoler> {
    private ArrayList<Cafe_menu_Item> data = null;
    SubCommunity_Adapter.OnItemClickListener mListener;

    public Cafe_menu_Adapter(ArrayList<Cafe_menu_Item> list) {
        data = list;
    }

    @NonNull
    @Override
    public Cafe_menu_Adapter.ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_holder_menulist, parent, false);
        Cafe_menu_Adapter.ViewHoler vh = new Cafe_menu_Adapter.ViewHoler(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Cafe_menu_Adapter.ViewHoler holder, int position) {
        Cafe_menu_Item item = data.get(position);
        holder.menu_img.setImageDrawable(item.getMenu_img());
        holder.menu_name.setText(item.getMenu_name());
        holder.menu_price.setText(item.getMenu_price());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHoler extends RecyclerView.ViewHolder {

        private ImageView menu_img;
        private TextView menu_name;
        private TextView menu_price;

        //private String hashtag[];

        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            menu_img = itemView.findViewById(R.id.menu_image);
            menu_name = itemView.findViewById(R.id.menu_name);
            menu_price = itemView.findViewById(R.id.menu_price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        Cafe_menu_Item item = data.get(pos);
                        if(mListener != null) {
                            mListener.onItemClick(v, pos);
                        }
                    }
                }
            });
        }
    }
    public interface OnItemClickListener{
        void onItemClick(View v, int position);
    }

    public void setOnItemClickListener(SubCommunity_Adapter.OnItemClickListener listener){
        mListener = listener;
    }
}
