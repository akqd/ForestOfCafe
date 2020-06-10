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

public class MainCafeList_Adapter extends RecyclerView.Adapter<MainCafeList_Adapter.ViewHolder> {

    private ArrayList<MainCafeList_Item> data = null;
    MainCafeList_Adapter.OnItemClickListener mListner;

    public MainCafeList_Adapter(ArrayList<MainCafeList_Item> list) {
        //데이터 리스트 객체 전달
        data = list;
    }

    public MainCafeList_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 아이템 뷰를 위한 뷰 홀더 객체 생성하여 리턴.
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_holder_main_cafelist,parent,false);
        MainCafeList_Adapter.ViewHolder vh = new MainCafeList_Adapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MainCafeList_Adapter.ViewHolder holder, int position) {
        // 포지션에 대당하는 데이터를 뷰 홀더의 아이템 뷰에 표시함
        MainCafeList_Item item = data.get(position);
        holder.cafe_name.setText(item.getCafe_Name());
        holder.cafe_distance.setText(item.getCafe_distance());
        holder.cafe_openclose.setText(item.getCafe_openclose());
        holder.cafe_image.setImageDrawable(item.getCafe_Image());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {

        // 아이템 뷰를 저장하는 뷰 홀더 클래스

        private TextView cafe_name;
        private TextView cafe_distance;
        private TextView cafe_openclose;
        private ImageView cafe_image;


        public ViewHolder(@NonNull View itemView) { // 뷰 객체 인플레이션
            super(itemView);
            cafe_name = itemView.findViewById(R.id.tvCafeName);
            cafe_distance = itemView.findViewById(R.id.tvCafeDistance);
            cafe_openclose = itemView.findViewById(R.id.tvCafeOpenClose);
            cafe_image = itemView.findViewById(R.id.imgMainCafe1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        MainCafeList_Item item = data.get(pos);
                        if(mListner != null){
                            mListner.onItemClick(v,pos);
                        }
                    }
                }
            });
        }
    }
    public interface OnItemClickListener{
        void onItemClick(View v, int postion);
    }
    public void setOnItemClickListener(MainCafeList_Adapter.OnItemClickListener listener){
        mListner = listener;
    }
}
