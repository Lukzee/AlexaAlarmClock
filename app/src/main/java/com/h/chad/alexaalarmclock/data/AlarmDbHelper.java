package com.h.chad.alexaalarmclock.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.h.chad.alexaalarmclock.data.AlarmContract.AlarmEntry;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

/**
 * Created by chad on 3/15/2017.
 */

public class AlarmDbHelper  extends SQLiteOpenHelper{

    private final static String LOG_TAG = AlarmDbHelper.class.getName();
    private final static String DATABASE_NAME = "alexaAlarm.db";
    private final static int DATABASE_VERSION = 3;

    public AlarmDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TABLE =
                "CREATE TABLE " + AlarmEntry.TABLE_NAME + "( " +
                AlarmEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AlarmEntry.USER_DESCRIPTION + " TEXT NOT NULL, " +
                AlarmEntry.FILE_NAME + " TEXT NOT NULL, " +
                AlarmEntry.ALARM_ACTIVE + " INTEGER NOT NULL, " +
                AlarmEntry.ALARM_HOUR + " INTEGER NOT NULL, " +
                AlarmEntry.ALARM_MINUTE + " INTEGER NOT NULL, " +
                AlarmEntry.ALARM_DAYS + " TEXT);";
        db.execSQL(SQL_CREATE_TABLE);


    }
    //Currently on version 2
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.e("ON UPGRAGE " +LOG_TAG, "DATABASE VERSION " + DATABASE_VERSION);
        if(oldVersion < 3) {
            String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + AlarmEntry.TABLE_NAME;
            sqLiteDatabase.execSQL(SQL_DROP_TABLE);
            onCreate(sqLiteDatabase);
        }

    }
}
