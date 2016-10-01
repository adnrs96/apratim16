package com.dityish.apratim2k16;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;


public class MainHome extends AppCompatActivity {

    DrawerLayout drawer;
    Toolbar toolbar;
    TextView mTitle;
    Typeface tf;

    boolean exit=false;
    NavigationView nvDrawer;
    int currentapiVersion;
    android.support.v4.app.Fragment fragment=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        currentapiVersion = android.os.Build.VERSION.SDK_INT;

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tf = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/LemonMilk.ttf");
        mTitle.setTypeface(tf);

        if(currentapiVersion>=21)
        {
            toolbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        }
        else {
           toolbar.setBackgroundColor(getResources().getColor(R.color.dark_theme));
        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        nvDrawer = (NavigationView) findViewById(R.id.nvView);

        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar ab = getSupportActionBar();

        fragment = new Home_default();
        //toolbar.setTitle("");
        ab.setTitle("");
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        drawer.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                        exit = false;
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        nvDrawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                exit=false;
                Window window = getWindow();
                switch (menuItem.getItemId()) {
                    case R.id.nav_first_fragment:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.home4));
                        }
                        if(currentapiVersion>=21)
                        {
                            toolbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                        }
                        else {
                            toolbar.setBackgroundColor(getResources().getColor(R.color.dark_theme));
                        }
                        fragment = new AboutUs();
                        break;
                    case R.id.nav_second_fragment:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.home4));
                        }
                        if(currentapiVersion>=21)
                        {
                            toolbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                        }
                        else {
                            toolbar.setBackgroundColor(getResources().getColor(R.color.dark_theme));
                        }
                        fragment = new Schedule();
                        break;
                    case R.id.nav_third_fragment:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.home4));
                        }
                        if(currentapiVersion>=21)
                        {
                            toolbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                        }
                        else {
                            toolbar.setBackgroundColor(getResources().getColor(R.color.dark_theme));
                        }
                        toolbar.setBackgroundColor(getResources().getColor(R.color.prof));
                        fragment = new ProfShow();
                        break;
                    case R.id.nav_fifth_fragment:
                        if(currentapiVersion>=21)
                        {
                            toolbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                        }
                        else {
                            toolbar.setBackgroundColor(getResources().getColor(R.color.dark_theme));
                        }
                        fragment = new Home();
                        break;
                    case R.id.nav_seventh_fragment:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.home4));
                        }
                        Uri gmmIntentUri = Uri.parse("geo:30.7271143,76.8087713?z=15.75");
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        if (mapIntent.resolveActivity(getApplicationContext().getPackageManager()) != null) {
                            startActivity(mapIntent);
                        }
                        else
                        {
                            Toast.makeText(MainHome.this, "Google Maps not available", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.nav_eight_fragment:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.home4));
                        }
                        if(currentapiVersion>=21)
                        {
                            toolbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                        }
                        else {
                            toolbar.setBackgroundColor(getResources().getColor(R.color.dark_theme));
                        }
                        fragment = new Gallery();
                        break;
                    case R.id.nav_tenth_fragment:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.home4));
                        }
                        if(currentapiVersion>=21)
                        {
                            toolbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                        }
                        else {
                            toolbar.setBackgroundColor(getResources().getColor(R.color.dark_theme));
                        }
                        fragment = new ContactUs();
                        break;
                    case R.id.nav_eleventh_fragment:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.home4));
                        }
                        if(currentapiVersion>=21)
                        {
                            toolbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                        }
                        else {
                            toolbar.setBackgroundColor(getResources().getColor(R.color.dark_theme));
                        }
                        fragment = new Developers();
                        //toolbar.setTitle("Developers");
                        break;
                    case R.id.nav_twelfth_fragment:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.home4));
                        }

                        toolbar.setBackgroundColor(getResources().getColor(R.color.dark_theme));
                        fragment = new Sponsors();
                        break;
                    default:
                        break;
                }
                drawer.closeDrawers();
                menuItem.setChecked(true);
                if(!menuItem.getTitle().toString().equalsIgnoreCase("Map"))
                mTitle.setText(menuItem.getTitle());
                //toolbar.setTitle("");

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        if (fragment != null) {
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            android.support.v4.app.FragmentTransaction ft = fragmentManager.beginTransaction();
                            ft.setCustomAnimations(R.anim.slide_left_in, R.anim.slide_right_out, R.anim.slide_right_in, R.anim.slide_left_out);
                            ft.replace(R.id.flContent, fragment).commit();
                        }
                    }
                }, 350);

                return true;
            }
        });

        if (currentapiVersion >=14) {
            ab.setHomeButtonEnabled(true);
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        }

    }
            @Override
            public boolean onOptionsItemSelected(MenuItem item) {

                switch (item.getItemId()) {
                    case android.R.id.home:
                        drawer.openDrawer(GravityCompat.START);
                        return true;
                }
                return true;
            }

            @Override
            public void onBackPressed() {

                if (!drawer.isDrawerOpen(nvDrawer)) {
                        drawer.openDrawer(nvDrawer);
                    Toast.makeText(MainHome.this, "Press Again to Exit", Toast.LENGTH_SHORT).show();
                        exit = true;
                    return;
                    }
                else if(!exit && drawer.isDrawerOpen(nvDrawer)) {
                    drawer.closeDrawers();
                }

                if(exit)
                    System.exit(0);

            }
}
