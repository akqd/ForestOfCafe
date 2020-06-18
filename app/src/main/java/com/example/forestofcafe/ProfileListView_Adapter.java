package com.example.forestofcafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ProfileListView_Adapter extends BaseAdapter {
    ArrayList<ProfileListView_Item> item = null;
    Context context;
    TextView tv_profile_menu;
    ImageView imgv_profile_menu;

    public ProfileListView_Adapter(ArrayList<ProfileListView_Item> list, Context _context) {
        item = list;
        context = _context;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ProfileListView_Item data = item.get(position);
        View view = View.inflate(context, R.layout.view_listview_profile, null);
        tv_profile_menu = view.findViewById(R.id.tv_profile_menu);
        imgv_profile_menu = view.findViewById(R.id.imgv_profile_menu);
        tv_profile_menu.setText(data.getMenu_str());
        imgv_profile_menu.setImageResource(data.getMenu_icon());
        return view;
    }

}
