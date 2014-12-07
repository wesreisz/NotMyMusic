package com.wesleyreisz.notmymusic.activity;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.wesleyreisz.notmymusic.R;

/**
 * Created by wesleyreisz on 12/7/14.
 */
public class NotMyMusicPreferenceActivity extends PreferenceActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
