package com.mrawesome.wenurture;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    // TODO: 15-04-2018 add drawable in @file_manager_menu.xml
    // TODO: 19-04-2018 Add Progress Bar instead of button to continue, 3-4sec autolaunch to next activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView appName = findViewById(R.id.app_name_main);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),"fonts/Stingray.otf");
        appName.setTypeface(custom_font);

        Button button = findViewById(R.id.testButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
