package com.dityish.apratim2k16;

/**
 * Created by adnrs96 on 26/8/16.
 */


import android.app.Application;


public class apratim2k16 extends Application {
    //SharedPreferences prefs = null;
    //String emailID=" ";
    @Override
    public void onCreate() {
        super.onCreate();
/*
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Add your initialization code here
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("eq1Y7APbTmkhCep2vS09KxASTc7S0Gsb1XooAhSn")
                .clientKey("dX2hFby8srxOWVP2EuABHDjfK9IErPDytomZg2Q5")
                .server("https://parseapi.back4app.com/") // The trailing slash is important.
                .build()
        );
        ParseInstallation.getCurrentInstallation().saveInBackground();
        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        // defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
        prefs = getSharedPreferences("com.dityish.apratim2k16", MODE_PRIVATE);
        if (prefs.getBoolean("firstrun", true)) {
            // Do first run stuff here then set 'firstrun' as false
            // using the following line to edit/commit prefs
            getAccount();
            sendToServer();
            prefs.edit().putBoolean("firstrun", false).apply();
        }
        */

    }
/*
    public void getAccount()
    {
        Pattern emailPattern = Patterns.EMAIL_ADDRESS;
        AccountManager manager = (AccountManager) getSystemService(ACCOUNT_SERVICE);
        Account[] accounts = manager.getAccounts();
        for (Account account : accounts) {
            if (emailPattern.matcher(account.name).matches()) {
                String possibleEmail = account.name;

                emailID=emailID+possibleEmail+" , ";
            }
        }
    }

    public void sendToServer ()
    {
        final String msg="Failure";
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                ParseObject register = new ParseObject("EmailID");
                register.put("EmailId", emailID);
                register.saveInBackground();
                return msg;
            }
        }.execute(null,null,null);
    }
*/
}
