package com.dityish.apratim2k16;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactAdapter extends ArrayAdapter<String> implements SHARED_CONSTANTS {
    private LayoutInflater mInflater;
    private final Context context;
    int t=0;
    String[] name;
    String[] number;
    String[] email;
    Bitmap[] pics;
    public ContactAdapter(Context context, String[] item, String[] name, String[] number, String[] email,Bitmap[] pics)
    {
        super(context,R.layout.custom_contact, item);
        this.context=context;
        this.name=name;
        this.number=number;
        this.email=email;
        this.pics=pics;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Holder holder;
        String str=getItem(position);
        final Animation anim= AnimationUtils.loadAnimation(getContext(), R.anim.home_fade);
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(number[position].equals("+919465541430"))
        {
            convertView=mInflater.inflate(R.layout.custom_contact_ashim,parent,false);
        }
        else
        {
            convertView=mInflater.inflate(R.layout.custom_contact,parent,false);
        }
        holder = new Holder();
        holder.teamImage=(ImageView)convertView.findViewById(R.id.teamImage);
        holder.head=(TextView) convertView.findViewById(R.id.head);
        holder.details=(TextView) convertView.findViewById(R.id.name);
        convertView.setTag(holder);
        try {
            holder.head.setText(str);
            if(number[position].equals("+919465541430"))
            {
                holder.details.setText(name[position]+"\n"+number[position]+"\n+918558056929");
            }
            else
            {
                holder.details.setText(name[position]+"\n"+number[position]);
            }
            holder.teamImage.setImageBitmap(pics[position]);
        }
        catch (NullPointerException e)
        {
            Log.d("Exception occured","Exception handler at getview in developer adapter");
        }


        if(t<position) {
            convertView.startAnimation(anim);
        }

        t=position;
        return convertView;
    }

    public class Holder
    {
        public TextView head;
        public ImageView teamImage;
        public TextView details;
    }
}
