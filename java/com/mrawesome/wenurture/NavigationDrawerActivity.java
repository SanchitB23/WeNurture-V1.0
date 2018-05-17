package com.mrawesome.wenurture;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class NavigationDrawerActivity extends AppCompatActivity implements DrawerLayout.DrawerListener{

    /**
     * Open another app.
     *
     * @param context     current Context, like Activity, App, or Service
     * @param packageName the full package name of the app to open
     * @return true if likely successful, false if unsuccessful
     */
    // TODO: 14-04-2018 Add App bar menus
    public static boolean openApp(Context context, String packageName) {
        PackageManager manager = context.getPackageManager();
        try {
            Intent i = manager.getLaunchIntentForPackage(packageName);
            if (i == null) {
                return false;
                //throw new ActivityNotFoundException();
            }
            i.addCategory(Intent.CATEGORY_LAUNCHER);
            context.startActivity(i);
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }

    DrawerLayout mDrawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
         mDrawerLayout = findViewById(R.id.drawerLayout);



//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_manage);
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        DrawerLayout naviDrawer = (DrawerLayout) findViewById(R.id.drawerLayout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this,naviDrawer,toolbar,R.string.navi_drawer_open,R.string.navi_drawer_close
//        );
//        naviDrawer.addDrawerListener(toggle);
//        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle navigation view item clicks here.
                /*int id = item.getItemId();

                if (id == R.id.navHome) {
                } else if (id == R.id.navAccInfo) {

                } else if (id == R.id.navVAttendance) {
//            openApp(this,"app.com.tedconsulting.vattendancestudent_shardauniversity");
                    Intent i = new Intent(NavigationDrawerActivity.this,RegisterActivity.class);
                    startActivity(i);

                } else if (id == R.id.navLogOut) {

                } else if (id == R.id.navFeedBack) {

                } else if (id == R.id.navContactUs) {

                }
                */
                switch (item.getItemId()){
                    case R.id.navHome:
                        Intent intent = new Intent(NavigationDrawerActivity.this,MainActivity.class);
                        startActivity(intent);
                        return true;
                }
                item.setChecked(true);
                mDrawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.top_bar_menu, menu);
        return true;
    }*/

    // TODO: 11-03-2018 Not Able to do anything when clicking on Navi Item
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.navHome) {
//        } else if (id == R.id.navAccInfo) {
//
//        } else if (id == R.id.navVAttendance) {
////            openApp(this,"app.com.tedconsulting.vattendancestudent_shardauniversity");
//       /* Intent i;
//        PackageManager packageManager = getPackageManager();
//        i = packageManager.getLaunchIntentForPackage("com.whatsapp");
//            assert i != null;
//            i.addCategory(Intent.CATEGORY_LAUNCHER);
//        startActivity(i);*/
//
//        } else if (id == R.id.navLogOut) {
//
//        } else if (id == R.id.navFeedBack) {
//
//        } else if (id == R.id.navContactUs) {
//
//        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(View drawerView) {
        navigationView.bringToFront();
        mDrawerLayout.requestLayout();
        mDrawerLayout.bringToFront();
    }

    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }
}
