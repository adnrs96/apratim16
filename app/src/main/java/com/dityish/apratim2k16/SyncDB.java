package com.dityish.apratim2k16;

import android.content.Context;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import android.content.res.Resources;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SyncDB implements SHARED_CONSTANTS {


    static private Resources resources;
    static private String output;

    public static void refreshEvent(Context context)  {

       resources = context.getResources();
        final Database db = new Database(context);


        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

            int c=0;
            for(int i=0; i < eventsNames.length; i++){

                output = LoadFile(eventsNames[i], true);

                String [] breakdown = output.split("\n");
                JSONObject jsonObject = new JSONObject();
                jsonObject.accumulate("id",breakdown[0]);
                jsonObject.accumulate("eventName",breakdown[1]);
                jsonObject.accumulate("location",breakdown[2]);
                jsonObject.accumulate("start",breakdown[3]);
                jsonObject.accumulate("end",breakdown[4]);
                jsonObject.accumulate("isProfShow",breakdown[5]);

                String newout = "";
                for(int j=6;j<breakdown.length;j++)
                {
                    newout+=breakdown[j]+"\n";
                }
                jsonObject.accumulate("desc",newout);
                int check=0;
                boolean isAllDay=false;
                if (jsonObject.getBoolean("isProfShow"))
                {
                    check=1;
                }

                Date start=dateFormat.parse(jsonObject.getString("start")),end=dateFormat.parse(jsonObject.getString("end"));
                Log.d("adnrs96" ,"Reached Check 1");
                EventModel event = new EventModel(Integer.toString(jsonObject.getInt("id")), jsonObject.getString("eventName").trim(),
                        jsonObject.getString("location"),start,
                        end, jsonObject.getString("desc"), isAllDay,check);
                db.addEvent(event);
                c++;
                Log.d("Event name" +c,jsonObject.getString("eventName")+dateFormat.format(start));
            }
        } catch (Exception e) {
            Log.d("adnrs96" ,"Reached Exception in events syncDB :"+e.getMessage());
        }



    }

    public static String LoadFile(String fileName, boolean loadFromRawFolder) throws IOException
    {
        //Create a InputStream to read the file into
        InputStream iS;

        if (loadFromRawFolder)
        {
            //get the resource id from the file name
            int rID = resources.getIdentifier("com.dityish.apratim2k16:raw/"+fileName, null, null);
            //get the file as a stream
            iS = resources.openRawResource(rID);
        }
        else
        {
            //get the file as a stream
            iS = resources.getAssets().open(fileName);
        }

        //create a buffer that has the same size as the InputStream
        byte[] buffer = new byte[iS.available()];
        //read the text file as a stream, into the buffer
        iS.read(buffer);
        //create a output stream to write the buffer into
        ByteArrayOutputStream oS = new ByteArrayOutputStream();
        //write this buffer to the output stream
        oS.write(buffer);
        //Close the Input and Output streams
        oS.close();
        iS.close();

        //return the output stream as a String
        return oS.toString();
    }

}
