
package com.example.cowcare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends ArrayAdapter {

    List list= new ArrayList();
    public ListAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
    static class LayoutHandler{

        TextView Name,Number;

    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row=convertView;
        LayoutHandler layoutHandler;
        if(row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row,parent,false);
            layoutHandler =new LayoutHandler();
            layoutHandler.Name=(TextView)row.findViewById(R.id.txtname);
            layoutHandler.Number=(TextView)row.findViewById(R.id.txtnumber);
            row.setTag(layoutHandler);
        }
        else
        {

            layoutHandler=(LayoutHandler)row.getTag();
        }
        DataProvider dataProvider=(DataProvider)this.getItem(position);
        layoutHandler.Name.setText(dataProvider.getName());
        layoutHandler.Number.setText(dataProvider.getNumber());

        return row;


    }
}