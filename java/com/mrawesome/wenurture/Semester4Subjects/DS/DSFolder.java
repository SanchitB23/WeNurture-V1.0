package com.mrawesome.wenurture.Semester4Subjects.DS;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mrawesome.wenurture.FileSystem.FileInfoArrayAdapter;
import com.mrawesome.wenurture.FileSystem.FileInfoArrayList;
import com.mrawesome.wenurture.R;

import java.util.ArrayList;

/**
 * Created by sanch on 14-04-2018 for WeNurture-SQLiteConnectivity.
 */
public class DSFolder extends AppCompatActivity {

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
        fileList.add(new FileInfoArrayList("Syllabus", 1,"https://drive.google.com/file/d/1niMUTNg6h13WhV3TKVrlzsHVyxtSMFiv/view?usp=sharing"));



        mFileAdapter = new FileInfoArrayAdapter(this, fileList);

        ListView listView = (ListView) findViewById(R.id.file_list);
        listView.setAdapter(mFileAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FileInfoArrayList currentFile = mFileAdapter.getItem(position);
                Intent intent;
                switch (currentFile.getFileName()){
                    case "Study Materials":
                        intent = new Intent(DSFolder.this, DSResources.class);
                        startActivity(intent);
                        break;
                        case "Unit 2":
                        intent = new Intent(DSFolder.this, DSResources.class);
                        startActivity(intent);
                        break;
                    case "Syllabus":
                        // Convert the String URL into a URI object (to pass into the Intent constructor)
                        Uri fileUri = Uri.parse(currentFile.getFileDir());

                        // Create a new intent to view the earthquake URI
                        intent = new Intent(Intent.ACTION_VIEW, fileUri);

                        // Send the intent to launch a new activity
                        startActivity(intent);
                        break;
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

