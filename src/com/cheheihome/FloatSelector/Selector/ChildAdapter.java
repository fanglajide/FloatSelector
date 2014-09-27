package com.cheheihome.FloatSelector.Selector;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chanlevel on 14/9/27.
 */
public class ChildAdapter extends BaseAdapter {
    Context mContext;
    List<List<String>> list = new ArrayList<List<String>>();
    List<String> childlist = new ArrayList<String>();
    int currentlist = 0;
    int currentitem = 0;
    ChildSelectListener childSelectListener;

    public ChildAdapter(Context context, List<List<String>> list) {
        this.mContext = context;
        this.list = list;
        if (list.size() > 0)
            childlist = list.get(0);
    }

    public void setChildSelectListener(ChildSelectListener childSelectListener) {
        this.childSelectListener = childSelectListener;
    }

    public void setList(List<List<String>> list) {
        this.list = list;
    }


    @Override
    public int getCount() {
        return childlist.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
//        ViewHolder holder=null;
//
//        if (convertView == null) {
//            holder = new ViewHolder();
//            convertView=new TextView(mContext);
//
//
//            convertView.setTag(holder.tv);
//        } else {
//            holder.tv = (TextView) convertView.getTag();
//
//        }
//
//
//        holder.tv.setText((CharSequence) childlist.get(position));
//
//        holder.tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                currentitem = position;
//                if (childSelectListener != null)
//                    childSelectListener.SelectItem(currentlist, currentitem);
//            }
//        });
        TextView textView = new TextView(mContext);
        textView.setText((CharSequence) childlist.get(position));
        textView.setTextSize(20);
        textView.setPadding(5, 10, 10, 5);
        textView.setTextColor(mContext.getResources().getColor(android.R.color.darker_gray));
        convertView = textView;
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentitem = position;
                if (childSelectListener != null)
                    childSelectListener.SelectItem(currentlist, currentitem);
            }
        });
        return convertView;
    }

    class ViewHolder {
        public TextView tv;
    }


    public void setCurrentlist(int i) {
        this.childlist = list.get(i);
        this.notifyDataSetChanged();
        currentlist = i;
    }

    public int getCurrentlist() {
        return currentlist;
    }

    public int getCurrentitem() {
        return currentitem;
    }


}
