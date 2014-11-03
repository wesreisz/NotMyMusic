package com.wesleyreisz.notmymusic.listener;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;

import com.wesleyreisz.notmymusic.R;

/**
 * Created by wesleyreisz on 10/27/14.
 */
public class MyTabListener implements ActionBar.TabListener{
    private Fragment fragment;
    public MyTabListener(Fragment fragment){
        this.fragment = fragment;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        ft.replace(R.id.container,fragment);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        ft.remove(fragment);
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
