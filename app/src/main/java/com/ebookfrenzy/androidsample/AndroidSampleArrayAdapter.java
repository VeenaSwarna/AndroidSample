package com.ebookfrenzy.androidsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class AndroidSampleArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public AndroidSampleArrayAdapter(Context context, String[] values) {
        super(context, R.layout.list_view_row_layout, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;
        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_view_row_layout, parent, false);
        }
        TextView textView = (TextView) rowView.findViewById(R.id.title);
        ImageView image = (ImageView) rowView.findViewById(R.id.list_image);
        textView.setText(values[position]);


        switch (position) {
            case 0:
                image.setImageResource(R.drawable.health);
                break;
            case 1:
                image.setImageResource(R.drawable.workout);
                break;
            case 2:
                image.setImageResource(R.drawable.haircare);
                break;
            case 3:
                image.setImageResource(R.drawable.skincare);
                break;
            case 4:
                image.setImageResource(R.drawable.herbs);
                break;
            case 5:
                image.setImageResource(R.drawable.tip);
                break;
        }

        return rowView;
    }
}