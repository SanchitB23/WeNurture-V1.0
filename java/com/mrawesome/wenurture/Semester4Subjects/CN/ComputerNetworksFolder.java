package com.mrawesome.wenurture.Semester4Subjects.CN;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

import com.mrawesome.wenurture.FileManagerActivity;
import com.mrawesome.wenurture.FileSystem.FileInfoArrayAdapter;
import com.mrawesome.wenurture.FileSystem.FileInfoArrayList;
import com.mrawesome.wenurture.MainActivity;
import com.mrawesome.wenurture.R;

import java.util.ArrayList;

/**
 * Created by sanch on 14-04-2018 for WeNurture-SQLiteConnectivity.
 */
public class ComputerNetworksFolder extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private FileInfoArrayAdapter mFileAdapter;
    int pdfIcon = R.drawable.ic_pdf;
    int docIcon = R.drawable.ic_doc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);


        final ArrayList<FileInfoArrayList> fileList = new ArrayList<FileInfoArrayList>();
        fileList.add(new FileInfoArrayList("Study Materials", 0));


        mFileAdapter = new FileInfoArrayAdapter(this,fileList);

        ListView listView = (ListView) findViewById(R.id.file_list);
        listView.setAdapter(mFileAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FileInfoArrayList currentFile = mFileAdapter.getItem(position);
                Intent intent;
                switch (currentFile.getFileName()){
                    case "Study Materials":
                        intent = new Intent(ComputerNetworksFolder.this, CNResources.class);
                        startActivity(intent);
                        break;

                    case "Unit 2":
                        intent = new Intent(ComputerNetworksFolder.this, CNUnit2.class);
                        startActivity(intent);
                        break;
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
                menuItemIntent = new Intent(ComputerNetworksFolder.this,MainActivity.class);
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
