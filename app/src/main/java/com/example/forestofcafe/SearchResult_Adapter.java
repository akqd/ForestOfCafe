package com.example.forestofcafe;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchResult_Adapter extends RecyclerView.Adapter<SearchResult_Adapter.ViewHolder> {

    private ArrayList<SearchResult_Item> data = null;
    OnItemClickListener mListner;

    public SearchResult_Adapter(ArrayList<SearchResult_Item> list) {
        //데이터 리스트 객체 전달
        data = list;
    }

    @Override
    public SearchResult_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 아이템 뷰를 위한 뷰 홀더 객체 생성하여 리턴.
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_holder_search, parent, false);
        SearchResult_Adapter.ViewHolder vh = new SearchResult_Adapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // 포지션에 대당하는 데이터를 뷰 홀더의 아이템 뷰에 표시함
        SearchResult_Item item = data.get(position);
        holder.cafe_image.setImageDrawable(item.getCafe_image());
        holder.tv_title.setText(item.getCafe_title());
        holder.tv_OP_CL.setText(item.getCafe_OP_CL());
        holder.tv_distance.setText(item.getCafe_distance());
        holder.tv_keyword.setText(item.getCafe_keyword());
        holder.tv_location.setText(item.getCafe_location());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        // 아이템 뷰를 저장하는 뷰 홀더 클래스

        private ImageView cafe_image;
        private TextView tv_title;
        private TextView tv_location;
        private TextView tv_OP_CL;
        private TextView tv_keyword;
        private TextView tv_distance;


        public ViewHolder(@NonNull View itemView) { // 뷰 객체 인플레이션
            super(itemView);
            cafe_image = itemView.findViewById(R.id.cafe_image);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_location = itemView.findViewById(R.id.tv_location);
            tv_OP_CL = itemView.findViewById(R.id.tv_OP_CL);
            tv_keyword = itemView.findViewById(R.id.tv_keyword);
            tv_distance = itemView.findViewById(R.id.tv_distance);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        SearchResult_Item item = data.get(pos);
                        if (mListner != null) {
                            mListner.onItemClick(v, pos);
                        }
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int postion);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListner = listener;
    }
}
