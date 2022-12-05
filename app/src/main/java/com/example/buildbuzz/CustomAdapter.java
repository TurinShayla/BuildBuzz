package com.example.buildbuzz;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Site> {
    private Activity context;
    private List<Site> siteList;

    public CustomAdapter(Activity context, List<Site> siteList) {
        super(context, R.layout.sample_layout, siteList);
        this.context=context;
        this.siteList=siteList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.sample_layout,null,true);
        Site site=siteList.get(position);
        TextView t1=view.findViewById(R.id.id_name_view);
        TextView t2=view.findViewById(R.id.id_roadClosed_view);

        t1.setText((site.getName()));
        t2.setText(site.getRoadClosed());
        return view;
      //  return super.getView(position, convertView, parent);
    }
}
