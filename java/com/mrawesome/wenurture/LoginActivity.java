package com.mrawesome.wenurture;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

    private EditText loginDetailText;
    private EditText loginPassText;
    private Button signInbutton;
    private TextView toRegister;
    private TextView skipSignIn;
    private TextView appNameLogo;

     /*TODO: 18-02-2018 Add Email/SysId Verification and Password, Add Save Password Option*/
     // TODO: 14-04-2018 Look Better
     // TODO: 15-04-2018 Solve LogIn with sql Issue
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginDetailText = (EditText) findViewById(R.id.userDetailEditText);
        loginPassText = (EditText) findViewById(R.id.passwordDetailEditText);
        signInbutton = (Button) findViewById(R.id.signInButton);
        toRegister = findViewById(R.id.toRegisterButton);
        skipSignIn = findViewById(R.id.skipSignIn);
        skipSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInIntent = new Intent(LoginActivity.this,FileManagerActivity.class);
                startActivity(signInIntent);
            }
        });
        toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toRegisterIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(toRegisterIntent);
            }
        });
        signInbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"Log In Worked!",Toast.LENGTH_SHORT).show();
            }
        });
        appNameLogo = findViewById(R.id.app_name_login);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/Stingray.otf");
        appNameLogo.setTypeface(typeface);
    }
}
