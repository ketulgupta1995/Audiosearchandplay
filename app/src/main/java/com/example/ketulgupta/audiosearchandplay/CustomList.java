package com.example.ketulgupta.audiosearchandplay;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Ketul Gupta on 13-03-2017.
 */

public class CustomList extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] txt;
    private final String[] txt2;

    public CustomList(Activity context,
                      String[] txt,String[] txt2 ) {
        super(context, R.layout.list_single, txt);
        this.context = context;
        this.txt = txt;
        this.txt2 = txt2;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);

        TextView txtTitle2 = (TextView) rowView.findViewById(R.id.txt2);

        txtTitle.setText(txt[position]);

        txtTitle2.setText(txt2[position]);
        return rowView;
    }
}
