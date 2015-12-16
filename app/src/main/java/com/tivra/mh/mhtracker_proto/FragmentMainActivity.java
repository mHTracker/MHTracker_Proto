package com.tivra.mh.mhtracker_proto;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import view.FirstFragment;
import view.SecondFragment;

public class FragmentMainActivity extends FragmentActivity {
    int status=1;
    Button bn;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);
        viewPager =(ViewPager)findViewById(R.id.view_pager);
        SwipeAdaptor swipeAdaptor = new SwipeAdaptor(getSupportFragmentManager());
        viewPager.setAdapter(swipeAdaptor);
    }

    public void fre_load() {
       // viewPager =(ViewPager)findViewById(R.id.view_pager);
        //SwipeAdaptor swipeAdaptor = new SwipeAdaptor(getSupportFragmentManager());
        //viewPager.setAdapter(swipeAdaptor);
    }
}
