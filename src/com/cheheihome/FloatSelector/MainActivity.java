package com.cheheihome.FloatSelector;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import com.cheheihome.FloatSelector.Selector.ChildSelectListener;
import com.cheheihome.FloatSelector.Selector.ParentAdapter;
import com.cheheihome.FloatSelector.Selector.WindowView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    WindowView windowView;
    List<List<String>> childlist = new ArrayList<List<String>>();
    List<Object> parentlist = new ArrayList<Object>();


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initData();
        setupViews();
    }

    private void setupViews() {
        windowView = (WindowView) findViewById(R.id.wv);
        windowView.setParentlist(parentlist);
        windowView.setChildlist(childlist);
        windowView.setChildSelectListener(new ChildSelectListener() {
            @Override
            public void SelectItem(int parentitem, int childitem) {
                System.out.print(parentitem + ":" + childitem);
                Toast.makeText(MainActivity.this, parentitem + ":" + childitem, 500).show();
            }
        });
        windowView.setupListView();

    }

    public void initData() {
        parentlist.add("food");
        parentlist.add("vegetable");
        List<String> l1 = new ArrayList<String>();
        l1.add("pork");
        l1.add("meat");
        List<String> l2 = new ArrayList<String>();
        l2.add("tomato");
        l2.add("potato");
        childlist.add(l1);
        childlist.add(l2);


    }


}
