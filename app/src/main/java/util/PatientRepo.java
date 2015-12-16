package util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ravinder.Singroha on 12/16/2015.
 */
public class PatientRepo {
    private DBHelper dbHelper;

    public PatientRepo(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(Patient patient) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Patient.KEY_age, patient.age);
        values.put(Patient.KEY_email,patient.email);
        values.put(Patient.KEY_name, patient.name);

        // Inserting Row
        long patient_Id = db.insert(Patient.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) patient_Id;
    }
    public void delete(int patient_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(Patient.TABLE, Patient.KEY_ID + "= ?", new String[] { String.valueOf(patient_Id) });
        db.close(); // Closing database connection
    }
    public void update(Patient patient) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Patient.KEY_age, patient.age);
        values.put(Patient.KEY_email,patient.email);
        values.put(Patient.KEY_name, patient.name);

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(Patient.TABLE, values, Patient.KEY_ID + "= ?", new String[]{String.valueOf(patient.patient_ID)});
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>>  getPatientList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Patient.KEY_ID + "," +
                Patient.KEY_name + "," +
                Patient.KEY_email + "," +
                Patient.KEY_age +
                " FROM " + Patient.TABLE;


        ArrayList<HashMap<String, String>> patientList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> patient = new HashMap<String, String>();
                patient.put("id", cursor.getString(cursor.getColumnIndex(Patient.KEY_ID)));
                patient.put("name", cursor.getString(cursor.getColumnIndex(Patient.KEY_name)));
                patientList.add(patient);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return patientList;

    }

    public Patient getPatientById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Patient.KEY_ID + "," +
                Patient.KEY_name + "," +
                Patient.KEY_email + "," +
                Patient.KEY_age +
                " FROM " + Patient.TABLE
                + " WHERE " +
                Patient.KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;
        Patient patient = new Patient();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                patient.patient_ID =cursor.getInt(cursor.getColumnIndex(Patient.KEY_ID));
                patient.name =cursor.getString(cursor.getColumnIndex(Patient.KEY_name));
                patient.email  =cursor.getString(cursor.getColumnIndex(Patient.KEY_email));
                patient.age =cursor.getInt(cursor.getColumnIndex(Patient.KEY_age));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return patient;
    }

}
