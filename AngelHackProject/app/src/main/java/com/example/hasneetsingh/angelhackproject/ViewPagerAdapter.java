package com.example.hasneetsingh.angelhackproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by hasneetsingh on 07/05/17.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:return "Wall";
            case 1:return "Profile";
            case 2:return "Wall";
            case 3:return "Profile";


            default:return null;
        }
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new WallFragment();

            case 1:
                return new ProfileFragment();
            case 2:
                return new WallFragment();

            case 3:
                return new ProfileFragment();


            default:
                return null;
        }
    }



    @Override
    public int getCount() {
        return 4;
    }
}
