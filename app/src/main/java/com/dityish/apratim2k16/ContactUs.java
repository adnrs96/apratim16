package com.dityish.apratim2k16;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ContactUs extends Fragment {


    String[] CONTACT_HEAD={"Convener",
            "Co-Convener",
            "Secretary",
            "Joint Secretary",
            "Joint Secretary" ,
            "Joint Secretary" ,
            "Joint Secretary",
            "Treasurer",
            "Marketing Head",
            "Registration Head"};
    String[] CONTACT_NAME={"Aakash",
            "Vasu",
            "Inderdeep",
            "Deepanshu",
            "Shubham Goyal",
            "Sahil Puri",
            "Harinder",
            "Ashish",
            "Ashim",
            "Mridula"};

    String[] CONTACT_NUMBER= {"+919888370004",
            "+919646861515",
            "+918146618475",
            "+919530587815",
            "+919501177779",
            "+919780935213",
            "+919872964202",
            "+917814331944",
            "+918558056929",
            "+918146369596"};

    String[] CONTACT_EMAIL={"lorem_ipsum@lorem_ipsum.com",
            "lorem_ipsum@lorem_ipsum.com",
            "lorem_ipsum@lorem_ipsum.com",
            "lorem_ipsum@lorem_ipsum.com",
            "lorem_ipsum@lorem_ipsum.com",
            "lorem_ipsum@lorem_ipsum.com",
            "lorem_ipsum@lorem_ipsum.com",
            "lorem_ipsum@lorem_ipsum.com",
            "lorem_ipsum@lorem_ipsum.com",
            "lorem_ipsum@lorem_ipsum.com"};
    int [] Team_PICS={R.drawable.profile,
            R.drawable.profile,
            R.drawable.profile,
            R.drawable.profile,
            R.drawable.shubham_goyal,
            R.drawable.profile,
            R.drawable.harinder,
            R.drawable.ashish,
            R.drawable.ashim,
            R.drawable.mridula};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.activity_contact_us, container, false);

        ListView contactList=(ListView) view.findViewById(R.id.contactList);
        Bitmap[] pixy=new Bitmap[10];
        for(int i=0;i<Team_PICS.length;i++)
        {
            Bitmap pics= BitmapFactory.decodeResource(getResources(), Team_PICS[i]);
            pics=getRoundedShape(pics);
            pixy[i]=pics;
        }
        ListAdapter custom= new ContactAdapter(getActivity() ,CONTACT_HEAD,CONTACT_NAME,CONTACT_NUMBER,CONTACT_EMAIL,pixy);
        contactList.setAdapter(custom);

        Toast.makeText(getActivity(),"Click on a person to call or send an email to him", Toast.LENGTH_LONG).show();

        final AlertDialog dialog = new AlertDialog.Builder(getActivity()).create();
        dialog.setTitle("Contact");


        contactList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                dialog.setMessage("How would you like to contact " + CONTACT_NAME[position]);

                dialog.setButton2("Call", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent call = new Intent(Intent.ACTION_DIAL);
                        call.setData(Uri.parse("tel:" + CONTACT_NUMBER[position]));
                        startActivity(call);
                    }
                });

                dialog.setButton("Email", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent mail = new Intent(Intent.ACTION_VIEW);
                        mail.setType("plain/text");
                        mail.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
                        mail.putExtra(Intent.EXTRA_EMAIL, new String[]{CONTACT_EMAIL[position]});
                        mail.putExtra(Intent.EXTRA_SUBJECT, "");
                        mail.putExtra(Intent.EXTRA_TEXT, "\n\n\n\n\n\n\n\nSent from the official Apratim 2016 App");

                        try {
                            startActivity(Intent.createChooser(mail, "Send mail...(Preferably GMail) ;)"));
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(getActivity(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                dialog.show();
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
    public Bitmap getRoundedShape(Bitmap scaleBitmapImage) {
        int targetWidth = scaleBitmapImage.getWidth();
        int targetHeight = scaleBitmapImage.getHeight();
        Bitmap targetBitmap = Bitmap.createBitmap(targetWidth,
                targetHeight, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(targetBitmap);
        Path path = new Path();
        path.addCircle(((float) targetWidth - 1) / 2,
                ((float) targetHeight - 1) / 2,
                (Math.min(((float) targetWidth),
                        ((float) targetHeight)) / 2),
                Path.Direction.CCW);

        canvas.clipPath(path);
        Bitmap sourceBitmap = scaleBitmapImage;
        canvas.drawBitmap(sourceBitmap,
                new Rect(0, 0, sourceBitmap.getWidth(),
                        sourceBitmap.getHeight()),
                new Rect(0, 0, targetWidth, targetHeight), null);
        return targetBitmap;
    }
}
