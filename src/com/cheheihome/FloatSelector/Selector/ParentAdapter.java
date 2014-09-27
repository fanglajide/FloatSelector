package com.cheheihome.FloatSelector.Selector;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chanlevel on 14/9/27.
 */
public class ParentAdapter extends BaseAdapter {
    Context mContext;
    List<List<Object>> childlist = new ArrayList<List<Object>>();
    List<Object> parentlist = new ArrayList<Object>();
    ListView childListView;
    ChildAdapter childAdapter;
    int currentItem = 0;
    ParentSelectListener parentSelectListener;

    public void setParentSelectListener(ParentSelectListener parentSelectListener) {
        this.parentSelectListener = parentSelectListener;
    }

    public ParentAdapter(Context context, List<Object> list) {
        this.mContext = context;
        this.parentlist = list;

    }

    public void setChildListView(ListView childListView) {
        this.childListView = childListView;
    }

    public void setChildAdapter(ChildAdapter adapter) {
        childAdapter = adapter;


    }

    public void setChildlist(List<List<Object>> list) {
        this.childlist = list;


    }

    public void setParentlist(List<Object> list) {
        this.parentlist = list;
    }


    @Override
    public int getCount() {
        return parentlist.size();
    }

    @Override
    public Object getItem(int position) {
        return parentlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        TextView tv = new TextView(mContext);
        tv.setTextSize(20);
        tv.setText((CharSequence) parentlist.get(position));
       tv.setTextColor(mContext.getResources().getColor(android.R.color.black));
        tv.setPadding(5, 10, 10, 5);
        if(position==currentItem)tv.setBackgroundColor(mContext.getResources().getColor(android.R.color.holo_orange_light));
         convertView = tv;

        return convertView;
    }

    public int getCurrentItem() {
        return currentItem;
    }

    public void setCurrentItem(int currentItem) {
        this.currentItem = currentItem;
        if (parentSelectListener != null)
            parentSelectListener.SelectItem(currentItem);
    notifyDataSetChanged();
    }


}
