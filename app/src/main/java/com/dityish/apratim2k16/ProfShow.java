package com.dityish.apratim2k16;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ProfShow extends android.support.v4.app.Fragment {

    ImageButton show1,show2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_prof_show, container, false);
        show1 = (ImageButton)view.findViewById(R.id.imageButtonfortimewaste1);
        show2 = (ImageButton)view.findViewById(R.id.imageButtonfortimewaste2);

        show1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nativeAppIntent = new Intent(getActivity(),prof_show1.class);
                startActivity(nativeAppIntent);
            }
        });
        show2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nativeAppIntent = new Intent(getActivity(),prof_show2.class);
                startActivity(nativeAppIntent);
            }
        });


        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        int width = displaymetrics.widthPixels;
        jerryAnimation anim = new jerryAnimation(view,height,width);
        anim.con_anime().start();

        return view;
    }

}
