package com.example.android.miwok;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

/**
 * Created by Marc on 28.09.2017.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    public CategoryAdapter (FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new NumbersFragment();
            case 1:
                return new FamilyFragment();
            case 2:
                return new ColorsFragment();
            case 3:
                return new PhrasesFragment();
            default:
                Log.e("CategoryAdapter", "this should never happen");
                return new NumbersFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
