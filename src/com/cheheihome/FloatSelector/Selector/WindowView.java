package com.cheheihome.FloatSelector.Selector;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import com.cheheihome.FloatSelector.R;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chanlevel on 14/9/27.
 */
public class WindowView extends LinearLayout {

    Context mContext;
    ChildAdapter childAdapter;
    ParentAdapter parentAdapter;
    ListView childListView, parentListView;
    List<List<String>> childlist = new ArrayList<List<String>>();
    List<Object> parentlist = new ArrayList<Object>();

    ChildSelectListener childSelectListener;
    ParentSelectListener parentSelectListener;

    public WindowView(Context context) {
        super(context);
        this.mContext = context;

    }

    public WindowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.windowview, this);
        parentListView = (ListView) this.findViewById(R.id.parentlistView);
        childListView = (ListView) this.findViewById(R.id.childListView);

    }

    public WindowView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;

    }

    public void setChildSelectListener(ChildSelectListener listener) {
        this.childSelectListener = listener;

    }

    public void setParentSelectListener(ParentSelectListener listener) {
        this.parentSelectListener = listener;

    }

    public WindowView(Context context, List<Object> parentlist, List<List<String>> childlist) {
        super(context);
        this.parentlist = parentlist;
        this.childlist = childlist;

    }


    public void setChildlist(List<List<String>> list) {
        this.childlist = list;



    }

    public void setParentlist(List<Object> list) {
        this.parentlist = list;
    }

    public void setupListView() {
        childAdapter = new ChildAdapter(mContext, childlist);
        parentAdapter = new ParentAdapter(mContext, parentlist);
        parentAdapter.setChildAdapter(childAdapter);

        if (childSelectListener != null) childAdapter.setChildSelectListener(childSelectListener);
        if (parentSelectListener != null) parentAdapter.setParentSelectListener(parentSelectListener);
        parentListView.setAdapter(parentAdapter);
        childListView.setAdapter(childAdapter);
        parentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                parentAdapter.setCurrentItem(position);
                childAdapter.setCurrentlist(position);
            }
        });
        requestLayout();

    }


}
