package com.wesleyreisz.notmymusic.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by wesleyreisz on 12/2/14.
 */
public class BaseActivity extends Activity {
    private static final String TAG = "BASEACTIVITY SONG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Checking login");
        if(false){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
