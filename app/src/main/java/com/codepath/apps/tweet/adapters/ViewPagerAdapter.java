package com.codepath.apps.tweet.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.codepath.apps.tweet.fragments.HomeTimeLineFragment;
import com.codepath.apps.tweet.fragments.MentionsTimeLineFragment;

/**
 * Created by aharyadi on 11/5/16.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    String titles[] = {"Home","Mentions"};

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new HomeTimeLineFragment();
        }
        else if (position==1){
            return new MentionsTimeLineFragment();
        }
        else {
            return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}