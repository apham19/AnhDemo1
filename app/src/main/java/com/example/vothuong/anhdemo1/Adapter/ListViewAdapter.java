package com.example.vothuong.anhdemo1.Adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vothuong.anhdemo1.R;

import java.util.ArrayList;


public class ListViewAdapter extends BaseAdapter {

    private final LayoutInflater nInflater;
    private final ArrayList<String> listResult;
    private Context nContext;



    public ListViewAdapter(Context context, ArrayList<String> listResult){
        this.nContext = context;
        this.listResult = listResult;
        nInflater= (LayoutInflater) nContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listResult.size();
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
        ViewHolder holder;
        if(convertView == null){
            convertView = nInflater.inflate(R.layout.list_item, parent,false);
            holder = new ViewHolder();
            holder.textView1 = (TextView) convertView.findViewById(R.id.list_view_tv1);
            holder.textView2 = (TextView) convertView.findViewById(R.id.list_view_tv2);
            holder.textView3 = (TextView) convertView.findViewById(R.id.list_view_tv3);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView1.setText(String.valueOf(position));
        holder.textView3.setText(String.valueOf(position));
        //holder.textView2.setText(listResult.size());
        if(position %2 == 0){
            holder.textView1.setVisibility(View.VISIBLE);
            holder.textView3.setVisibility(View.INVISIBLE);
        }else{
            holder.textView1.setVisibility(View.INVISIBLE);
            holder.textView3.setVisibility(View.VISIBLE);
        }

        /*View rowView = nInflater.inflate(R.layout.list_item, parent,false);
        TextView textView = (TextView) rowView.findViewById(R.id.list_view_tv);
        textView.setText(String.valueOf(position));
        textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });*/
        return convertView;
    }

class ViewHolder {
        TextView textView1;
        TextView textView2;
        TextView textView3;
    }



}
