package util;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Ravinder.Singroha on 12/16/2015.
 */
public class DBHelper extends SQLiteOpenHelper {

    //version number to upgrade database version
    //each time if you Add, Edit table, you need to change the
    //version number.
    private static final int DATABASE_VERSION = 4;

    // Database Name
    private static final String DATABASE_NAME = "mHealth.db";

    public DBHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here

        String CREATE_TABLE_PATIENT = "CREATE TABLE " + Patient.TABLE  + "("
                + Patient.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Patient.KEY_name + " TEXT, "
                + Patient.KEY_age + " INTEGER, "
                + Patient.KEY_email + " TEXT )";

        db.execSQL(CREATE_TABLE_PATIENT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + Patient.TABLE);

        // Create tables again
        onCreate(db);
    }
}
