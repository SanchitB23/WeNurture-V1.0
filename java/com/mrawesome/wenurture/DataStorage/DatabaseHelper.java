package com.mrawesome.wenurture.DataStorage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.mrawesome.wenurture.DataStorage.DatabaseDetails.AccountDetails;

/**
 * Created by sanch on 26-03-2018 for WeNurture.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "AccDetails";
    private static final int DB_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ACCOUNT_DETAILS_TABLE = "CREATE TABLE " + AccountDetails.TABLE_NAME + " ("
                + AccountDetails._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + AccountDetails.COLUMN_FULL_NAME + " TEXT, "
                + AccountDetails.COLUMN_EMAIL_ID + " TEXT NOT NULL, "
                + AccountDetails.COLUMN_PH_NUMBER + " INTEGER NOT NULL, "
                + AccountDetails.COLUMN_PASSWORD + " TEXT,"
                + AccountDetails.COLUMN_SYS_ID + " INTEGER, "
                + AccountDetails.COLUMN_ROLL_NUM + " INTEGER,);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_ACCOUNT_DETAILS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Null
    }
}
