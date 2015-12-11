package com.tivra.mh.mhtracker_proto;
import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.FrameStats;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;

import view.FirstFragment;
import view.SecondFragment;


public class TestActivity extends Activity {

    boolean status=false;
    Button bn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        bn=(Button)findViewById(R.id.bn);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v){


//                FragmentManager fragmentManager= getFragmentManager();

              //FragmentTransaction fragmentTransaction =
               // android.support.v4.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if(!status){
                    FirstFragment f1 = new FirstFragment();
                   // fragmentTransaction.add(R.id.fc1, f1);
                    //fragmentTransaction.commit();
                    bn.setText("Load Second fragment");
                    status=true;
                }
                else
                {
                    SecondFragment f2= new SecondFragment();
                    //fragmentTransaction.add(R.id.fc1, f2);
                    //fragmentTransaction.commit();
                    bn.setText("Load First fragment");
                    status=false;
                }
            }
        });
    }

}
