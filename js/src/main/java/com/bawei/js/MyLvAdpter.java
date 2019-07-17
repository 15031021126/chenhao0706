package com.bawei.js;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/*
 *@Auther:陈浩
 *@Date: 2019/7/17
 *@Time:19:38
 *@Description:${DESCRIPTION}
 * */public class MyLvAdpter  extends BaseAdapter {
     private ArrayList<String> stringArrayList;
     private Context context;

    public MyLvAdpter(ArrayList<String> stringArrayList, Context context) {
        this.stringArrayList = stringArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return stringArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;

        if(convertView==null){

            convertView=View.inflate(context,android.R.layout.simple_expandable_list_item_1,null);

            holder=new ViewHolder();

            holder.textView=convertView.findViewById(android.R.id.text1);

            convertView.setTag(holder);

        }else{

            holder=(ViewHolder)convertView.getTag();
        }
        holder.textView.setText(stringArrayList.get(position));
        return convertView;
    }
    class ViewHolder{
        TextView textView;
    }
}
