package com.mrawesome.wenurture;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mrawesome.wenurture.FileSystem.FileInfoArrayAdapter;
import com.mrawesome.wenurture.FileSystem.FileInfoArrayList;
import com.mrawesome.wenurture.Semester4Subjects.Semester4Folder;

import java.util.ArrayList;

public class FileManagerActivity extends AppCompatActivity {


    /**
     * FileAdapter works
     */
    private DrawerLayout mDrawerLayout;
    private FileInfoArrayAdapter mFileAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_file_manager);
        setContentView(R.layout.activity_navigation_drawer);
        int pdfIcon = R.drawable.ic_pdf;

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);


            final ArrayList<FileInfoArrayList> fileList = new ArrayList<FileInfoArrayList>();
            fileList.add(new FileInfoArrayList("Semester 1",0));
            fileList.add(new FileInfoArrayList("Semester 2",0));
            fileList.add(new FileInfoArrayList("Semester 3",0));
            fileList.add(new FileInfoArrayList("Semester 4",0));

            mFileAdapter = new FileInfoArrayAdapter(this,fileList);

            ListView listView = (ListView) findViewById(R.id.file_list);
            listView.setAdapter(mFileAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    FileInfoArrayList currentFile = mFileAdapter.getItem(position);
                    if (currentFile.getFileType() == 0){
                        Intent intent = new Intent(FileManagerActivity.this, Semester4Folder.class);
                        startActivity(intent);
                    }
                }
            });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.file_manager_menu, menu);
        return true;
    }

    private Intent menuItemIntent;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        // TODO: 15-04-2018 Create Activity for each
        switch (item.getItemId()) {
            case R.id.logOutMenuItem:
               menuItemIntent = new Intent(FileManagerActivity.this,MainActivity.class);
               startActivity(menuItemIntent);
                return true;
            case R.id.contactUsMenuItem:
                // Do nothing for now
                return true;
            case R.id.feedbackMenuItem:
                // Do nothing for now
                return true;
            case R.id.aboutAppMenuItem:
                // Do nothing for now
                return true;
            case R.id.accInfoItem:
                // Do nothing for now
                return true;
            case R.id.checkAttendanceMenuItem:
                PackageManager manager = this.getPackageManager();
                try {
                    menuItemIntent = manager.getLaunchIntentForPackage("app.com.tedconsulting.vattendancestudent_shardauniversity");

                    menuItemIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                    this.startActivity(menuItemIntent);
                    return true;
                } catch (ActivityNotFoundException e) {
                    Log.e("VattendanceError",""+e);
                    return false;
                }
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
