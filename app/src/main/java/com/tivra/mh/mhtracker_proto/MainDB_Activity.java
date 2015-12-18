package com.tivra.mh.mhtracker_proto;

import android.app.Activity;
import android.app.ListActivity;
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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import util.PatientRepo;


public class MainDB_Activity extends ListActivity implements android.view.View.OnClickListener{

    Button btnAdd,btnGetAll;
    TextView patient_Id;

    @Override
    public void onClick(View view) {
        if (view== findViewById(R.id.btnAdd)){

            Intent intent = new Intent(this,PatientDetails.class);
            intent.putExtra("patient_Id",0);
            startActivity(intent);

        }else {

            PatientRepo repo = new PatientRepo(this);

            ArrayList<HashMap<String, String>> patientList =  repo.getPatientList();
            if(patientList.size()!=0) {
                ListView lv = getListView();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                        patient_Id = (TextView) view.findViewById(R.id.patient_Id);
                        String patientId = patient_Id.getText().toString();
                        Intent objIndent = new Intent(getApplicationContext(),PatientDetails.class);
                        objIndent.putExtra("patient_Id", Integer.parseInt( patientId));
                        startActivity(objIndent);
                    }
                });
                ListAdapter adapter = new SimpleAdapter( MainDB_Activity.this,patientList, R.layout.view_patient_entry, new String[] { "id","name"}, new int[] {R.id.patient_Id, R.id.patient_name});
                setListAdapter(adapter);
            }else{
                Toast.makeText(this,"No patient!",Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_db_layout);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnGetAll = (Button) findViewById(R.id.btnGetAll);
        btnGetAll.setOnClickListener(this);

    }




}