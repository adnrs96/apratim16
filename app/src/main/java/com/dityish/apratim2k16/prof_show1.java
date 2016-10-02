package com.dityish.apratim2k16;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by adnrs96 on 2/10/16.
 */

public class prof_show1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prof_show1);
        System.gc();
    }
    @Override
    protected void onStop() {
        super.onStop();
        System.gc();
    }
}
