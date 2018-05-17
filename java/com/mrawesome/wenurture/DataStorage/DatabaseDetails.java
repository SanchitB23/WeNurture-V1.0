package com.mrawesome.wenurture.DataStorage;

import android.provider.BaseColumns;

/**
 * Created by sanch on 26-03-2018 for WeNurture.
 */

public final class DatabaseDetails {
    public DatabaseDetails() {
    }

    public static final class AccountDetails implements BaseColumns {
        public static final String TABLE_NAME = "account_details";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_FULL_NAME = "name";
        public static final String COLUMN_EMAIL_ID = "email";
        public static final String COLUMN_PH_NUMBER = "phone number";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_SYS_ID = "system ID";
        public static final String COLUMN_ROLL_NUM = "roll number";
        public static final String COLUMN_GENDER = "gender";

        public static final int GENDER_MALE = 1;
        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_FEMALE = 2;
    }
}
