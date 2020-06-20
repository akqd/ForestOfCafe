package com.example.forestofcafe;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SettingListView_Adapter  extends BaseAdapter {
    ArrayList<SettingListView_Item> item = null;
    Context context;
    TextView tv_setting_menu;
    ImageView iv_setting_menu;

    public SettingListView_Adapter(ArrayList<SettingListView_Item> list, Context _context) {
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
        SettingListView_Item data = item.get(position);
        View view = View.inflate(context, R.layout.view_listview_setting, null);
        tv_setting_menu = view.findViewById(R.id.tv_setting_menu);
        iv_setting_menu = view.findViewById(R.id.iv_setting_menu);
        tv_setting_menu.setText(data.getMenu_str());
        iv_setting_menu.setImageResource(data.getMenu_icon());
        return view;
    }

}