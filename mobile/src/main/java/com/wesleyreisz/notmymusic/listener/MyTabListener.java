package com.wesleyreisz.notmymusic.listener;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.wesleyreisz.notmymusic.R;
import com.wesleyreisz.notmymusic.fragment.BioFragment;
import com.wesleyreisz.notmymusic.fragment.DetailsFragment;
import com.wesleyreisz.notmymusic.fragment.MoreSongsFragment;

/**
 * Created by wesleyreisz on 10/27/14.
 */
public class MyTabListener implements ActionBar.TabListener{
    private Activity mActivity;
    private Fragment fragment;
    private Fragment moreFragment;
    private FrameLayout fm;

    public MyTabListener(Activity activity, Fragment fragment){
        this.fragment = fragment;
        this.mActivity = activity;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

        if(fragment instanceof DetailsFragment){
            Log.d("TEST", "Loading detailsfragment");
            fm = (FrameLayout)mActivity.findViewById(R.id.containerMore);
            fm.setVisibility(View.VISIBLE);
            moreFragment = new BioFragment();
            ft.replace(R.id.containerMore, moreFragment);
        }else{
            fm = (FrameLayout)mActivity.findViewById(R.id.containerMore);
            fm.setVisibility(View.GONE);
        }

        ft.replace(R.id.container,fragment);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        ft.remove(fragment);


        if(moreFragment!=null && fm !=null){
            fm.setVisibility(View.GONE);
            ft.remove(moreFragment);
        }
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
