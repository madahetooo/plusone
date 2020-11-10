package com.yat.firsthelloworldapp.tools;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.yat.firsthelloworldapp.R;

public class MyListViewAdapter extends ArrayAdapter {

    private final Activity context;
    private final String[] mainTitle;
    private final String[] subTitle;
    private final Integer[] image;


    public MyListViewAdapter(@NonNull Activity context, String[] mainTitle, String[] subTitle, Integer[] image) {

        super(context, R.layout.list_view_content, mainTitle);
        this.context=context;
        this.mainTitle = mainTitle;
        this.subTitle = subTitle;
        this.image = image;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_view_content, null, true);

        TextView titleText = rowView.findViewById(R.id.tx_mainTitle);
        TextView subtitleText = rowView.findViewById(R.id.tx_subTitle);
        ImageView profilePhoto = rowView.findViewById(R.id.iv_profile);


        titleText.setText(mainTitle[position]);
//        profilePhoto.setImageResource(image[position]);
        subtitleText.setText(subTitle[position]);

        return rowView;

    }

    ;
}
