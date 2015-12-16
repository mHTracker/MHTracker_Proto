package com.tivra.mh.mhtracker_proto;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import util.Patient;
import util.PatientRepo;

public class PatientDetails extends ActionBarActivity implements android.view.View.OnClickListener{

    Button btnSave ,  btnDelete;
    Button btnClose;
    EditText editTextName;
    EditText editTextEmail;
    EditText editTextAge;
    private int _Patient_Id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnClose = (Button) findViewById(R.id.btnClose);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextAge = (EditText) findViewById(R.id.editTextAge);

        btnSave.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnClose.setOnClickListener(this);


        _Patient_Id =0;
        Intent intent = getIntent();
        _Patient_Id =intent.getIntExtra("student_Id", 0);
        PatientRepo repo = new PatientRepo(this);
        Patient patient = new Patient();
        patient = repo.getPatientById(_Patient_Id);

        editTextAge.setText(String.valueOf(patient.age));
        editTextName.setText(patient.name);
        editTextEmail.setText(patient.email);
    }



    public void onClick(View view) {
        if (view == findViewById(R.id.btnSave)){
            PatientRepo repo = new PatientRepo(this);
            Patient patient = new Patient();
            patient.age= Integer.parseInt(editTextAge.getText().toString());
            patient.email=editTextEmail.getText().toString();
            patient.name=editTextName.getText().toString();
            patient.patient_ID=_Patient_Id;

            if (_Patient_Id==0){
                _Patient_Id = repo.insert(patient);

                Toast.makeText(this,"New Student Insert",Toast.LENGTH_SHORT).show();
            }else{

                repo.update(patient);
                Toast.makeText(this,"Student Record updated",Toast.LENGTH_SHORT).show();
            }
        }else if (view== findViewById(R.id.btnDelete)){
            PatientRepo repo = new PatientRepo(this);
            repo.delete(_Patient_Id);
            Toast.makeText(this, "Patient Record Deleted", Toast.LENGTH_SHORT);
            finish();
        }else if (view== findViewById(R.id.btnClose)){
            finish();
        }


    }

}