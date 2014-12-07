package com.wesleyreisz.notmymusic.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.wesleyreisz.notmymusic.Constants;
import com.wesleyreisz.notmymusic.R;
import com.wesleyreisz.notmymusic.util.AuthUtil;

/**
 * Created by wesleyreisz on 12/2/14.
 */
public class BaseActivity extends Activity {
    private static final String TAG = "BASEACTIVITY SONG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Checking login");

        if(!AuthUtil.isLoggedIn(this)){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
