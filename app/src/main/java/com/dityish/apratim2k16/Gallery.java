package com.dityish.apratim2k16;

/**
 * Created by adnrs96 on 26/8/16.
 * Modified by paraschadha on 25/9/16
 */

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.squareup.picasso.Picasso;


public class Gallery extends android.support.v4.app.Fragment {

    ProgressBar loading;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_gallery, container, false);
        System.gc();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        int width = displaymetrics.widthPixels;
        jerryAnimation anim = new jerryAnimation(view,height,width);
        anim.con_anime().start();
        final String[] links = {"https://apratim.herokuapp.com/five.jpg",
                "https://apratim.herokuapp.com/four.jpg",
                "https://apratim.herokuapp.com/one.jpg",
                "https://apratim.herokuapp.com/three.jpg",};
        ImageView pic1=(ImageView) view.findViewById(R.id.pic1);
        ImageView pic2=(ImageView) view.findViewById(R.id.pic2);
        ImageView pic3=(ImageView) view.findViewById(R.id.pic3);
        ImageView pic4=(ImageView) view.findViewById(R.id.pic4);
        loading=(ProgressBar) view.findViewById(R.id.loading);
        loading.setMax(100);

        loading.setProgress(40);

        Picasso.with(getActivity()).load(links[0]).into(pic1,new com.squareup.picasso.Callback()
        {
            @Override
            public void onSuccess() {
                loading.setVisibility(View.GONE);
            }

            @Override
            public void onError() {
                loading.setVisibility(View.GONE);
                Toast.makeText(getActivity(),"Failed to Load Images", Toast.LENGTH_SHORT).show();
            }
        });
        Picasso.with(getActivity()).load(links[1]).into(pic2);
        Picasso.with(getActivity()).load(links[2]).into(pic3);
        Picasso.with(getActivity()).load(links[3]).into(pic4);

        return view;
    }


}
