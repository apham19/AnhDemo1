package com.example.vothuong.anhdemo1.Adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vothuong.anhdemo1.R;


public class ListViewAdapter extends BaseAdapter {

    private final LayoutInflater nInflater;
    private Context nContext;


    public ListViewAdapter(Context context){
        nContext = context;
        nInflater= (LayoutInflater) nContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = nInflater.inflate(R.layout.list_item, parent,false);
        TextView textView = (TextView) rowView.findViewById(R.id.list_view_tv);
        textView.setText(String.valueOf(position));
        return rowView;
    }
}
