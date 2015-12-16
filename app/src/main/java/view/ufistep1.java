package view;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


import android.widget.TextView;

import com.tivra.mh.mhtracker_proto.R;

/**
 * Created by Ravinder.Singroha on 12/10/2015.
 */

public class ufistep1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewPager vp1;
        View view = inflater.inflate(R.layout.fre_layout, container, false);
      // vp1= view.findViewById(R.id.view_pager1)
        // viewPager =(ViewPager)findViewById(R.id.view_pager);
        //SwipeAdaptor swipeAdaptor = new SwipeAdaptor(getSupportFragmentManager());
        //viewPager.setAdapter(swipeAdaptor);

        return  view;
    };
}
