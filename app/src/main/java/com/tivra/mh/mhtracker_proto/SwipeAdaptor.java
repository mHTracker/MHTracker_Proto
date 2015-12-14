package com.tivra.mh.mhtracker_proto;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import view.FirstFragment;
import view.SecondFragment;

/**
 * Created by Ravinder.Singroha on 12/11/2015.
 */
public class SwipeAdaptor extends FragmentStatePagerAdapter {
    public SwipeAdaptor(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        Fragment fragment =new FirstFragment();
        Bundle bundle =new Bundle();
        bundle.putInt("count", position + 0);
        fragment.setArguments(bundle);
        if (position==3) {
            Fragment fragment1 =new SecondFragment();
           // Bundle bundle1 =new Bundle();
          //  bundle1.putInt("count", position + 0);
            fragment.setArguments(bundle);
            return fragment1;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
