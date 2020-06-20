package com.example.forestofcafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Profile_MyComment_Adapter extends RecyclerView.Adapter<Profile_MyComment_Adapter.ViewHolder> {
    ArrayList<Profile_MyComment_Item> data = null;
    Context context;

    public Profile_MyComment_Adapter(ArrayList<Profile_MyComment_Item> list) {
        data = list;
    }
    @Override
    public Profile_MyComment_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_holder_profile_mycomment, parent, false);
        Profile_MyComment_Adapter.ViewHolder vh = new Profile_MyComment_Adapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Profile_MyComment_Item item = data.get(position);
        holder.img_CommunityPost.setImageResource(item.getImg_post());
        holder.tv_CafeName.setText(item.getCafeName());
        holder.tv_CommentContent.setText(item.getComentCotent());
        holder.tv_CommentWriteTime.setText(item.getComentWriteTime());
        holder.tv_CommunityContent.setText(item.getCommunityContent());
        holder.tv_PostWriter.setText(item.getPostWriter());
        holder.tv_CafeLocation.setText(item.getCafeLocation());
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        Button btn_Modify, btn_Delete;
        ImageView img_PostWriter,img_CommunityPost,img_CommentCount;
        TextView tv_PostWriter, tv_CafeName, tv_CafeLocation,tv_CommunityContent, tv_CommentContent,tv_CommentWriteTime,tv_Coment;
        Profile_CustomDialog dialog;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dialog = null;
            btn_Modify = itemView.findViewById(R.id.btn_Modify);
            btn_Delete = itemView.findViewById(R.id.btn_Delete);
            img_PostWriter = itemView.findViewById(R.id.img_PostWriter);
            img_CommunityPost = itemView.findViewById(R.id.img_CommunityPost);
            img_CommentCount = itemView.findViewById(R.id.img_CommentCount);
            tv_Coment = itemView.findViewById(R.id.tv_Comment);
            tv_PostWriter = itemView.findViewById(R.id.tv_PostWriter);
            tv_CafeName = itemView.findViewById(R.id.tv_CafeName);
            tv_CafeLocation = itemView.findViewById(R.id.tv_CafeLocation);
            tv_CommentContent = itemView.findViewById(R.id.tv_CommentContent);
            tv_CommunityContent = itemView.findViewById(R.id.tv_CommunityContent);
            tv_CommentWriteTime = itemView.findViewById(R.id.tv_CommentWriteTime);
            tv_Coment.setText("내 댓글");
            btn_Delete.setText("삭제");
            btn_Modify.setText("수정");
            img_CommentCount.setImageResource(R.drawable.ic_comment);
            img_PostWriter.setImageResource(R.drawable.ic_profile);
            btn_Modify.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View.OnClickListener postiveListner = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(context,"수정 버튼을 누르셨습니다.",Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    };
                    View.OnClickListener negativeListner = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(context,"취소 버튼을 누르셨습니다.",Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    };
                    dialog = new Profile_CustomDialog(context,"댓글을 수정하시겠습니까?",postiveListner,negativeListner);
                    dialog.show();
                }
            });
            btn_Delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View.OnClickListener postiveListner = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(context,"삭제 버튼을 누르셨습니다.",Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    };
                    View.OnClickListener negativeListner = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(context,"취소 버튼을 누르셨습니다.",Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    };
                    dialog = new Profile_CustomDialog(context,"댓글을 삭제하시겠습니까?",postiveListner,negativeListner);
                    dialog.show();
                }
            });
        }
    }
}
