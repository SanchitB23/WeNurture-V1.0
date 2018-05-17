package com.mrawesome.wenurture;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mrawesome.wenurture.DataStorage.DatabaseHelper;

import static com.mrawesome.wenurture.DataStorage.DatabaseDetails.AccountDetails.COLUMN_EMAIL_ID;
import static com.mrawesome.wenurture.DataStorage.DatabaseDetails.AccountDetails.COLUMN_FULL_NAME;
import static com.mrawesome.wenurture.DataStorage.DatabaseDetails.AccountDetails.COLUMN_PASSWORD;
import static com.mrawesome.wenurture.DataStorage.DatabaseDetails.AccountDetails.COLUMN_PH_NUMBER;
import static com.mrawesome.wenurture.DataStorage.DatabaseDetails.AccountDetails.COLUMN_ROLL_NUM;
import static com.mrawesome.wenurture.DataStorage.DatabaseDetails.AccountDetails.COLUMN_SYS_ID;
import static com.mrawesome.wenurture.DataStorage.DatabaseDetails.AccountDetails.TABLE_NAME;
import static java.lang.Long.parseLong;

public class RegisterActivity extends Activity {

    // TODO: 18-02-2018 Add Captcha, OTP, Email Verification 
    // TODO: 18-02-2018 Add Sql addition for stuff inserted
    // TODO: 26-03-2018 Add Gender in layout

    Button mRegisterButton;
    long rowID;
    private EditText mAccountName;
    private EditText mAccountEmail;
    private EditText mAccountPhNum;
    private EditText mAccountPass;
    private EditText mAccountPassConfirm;
    private EditText mAccountSysID;
    private EditText mAccountRollNum;
    private TextView mLinkLogin;
    private TextView mAppName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAccountName = findViewById(R.id.textAddName);
        mAccountEmail = findViewById(R.id.textAddEMail);
        mAccountPhNum = findViewById(R.id.textAddPhoneNum);
        mAccountPass = findViewById(R.id.textAddPassword);
        mAccountPassConfirm = findViewById(R.id.textAddConfirmPassoword);
        mAccountSysID = findViewById(R.id.textAddSystemID);
        mAccountRollNum = findViewById(R.id.textAddRollNum);
        mLinkLogin = findViewById(R.id.link_login);
        mAppName = findViewById(R.id.app_name_register);

        mRegisterButton = findViewById(R.id.registerButton);
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAccountPass.getText().toString() != mAccountPassConfirm.getText().toString()) {
                    Snackbar.make(view, "Passwords do not match", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                } else if (mAccountEmail.getText().toString() == null) {
                    Snackbar.make(view, "Enter Valid Email", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                } else {
                    Snackbar.make(view, "Registered", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    addAccountToDB();
                    finish();
                }
            }
        });
        mLinkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        Typeface typefaceLogo = Typeface.createFromAsset(getAssets(),"fonts/Stingray.otf");
        mAppName.setTypeface(typefaceLogo);
    }

    private void addAccountToDB() {
        try {
            DatabaseHelper databaseHelper = new DatabaseHelper(this);
            SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(COLUMN_FULL_NAME, mAccountName.getText().toString().trim());
            values.put(COLUMN_EMAIL_ID, mAccountEmail.getText().toString().trim());
            values.put(COLUMN_PH_NUMBER, parseLong(mAccountPhNum.getText().toString().trim()));
            values.put(COLUMN_PASSWORD, mAccountPass.getText().toString().trim());
            values.put(COLUMN_SYS_ID, parseLong(mAccountSysID.getText().toString().trim()));
            values.put(COLUMN_ROLL_NUM, parseLong(mAccountRollNum.getText().toString().trim()));

            rowID = sqLiteDatabase.insert(TABLE_NAME, null, values);
        } catch (Exception e) {
            Toast.makeText(this, "DB Problem", Toast.LENGTH_SHORT).show();

        }
    }
}
