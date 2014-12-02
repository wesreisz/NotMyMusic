package com.wesleyreisz.notmymusic.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;
import com.wesleyreisz.notmymusic.Constants;
import com.wesleyreisz.notmymusic.R;

public class LoginActivity extends Activity {
    private static final String TAG = "LOGIN SONG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Parse.initialize(this, Constants.APP_ID, Constants.APP_SECRET);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ParseFacebookUtils.initialize(String.valueOf(R.string.facebook_app_id));

        ImageView faceBookButton = (ImageView)findViewById(R.id.imageViewFacebook);
        faceBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                ParseFacebookUtils.logIn(LoginActivity.this, new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException err) {
                        if (user == null) {
                            Log.d(TAG, "Uh oh. The user cancelled the Facebook login.");

                        } else if (user.isNew()) {
                            Log.d(TAG, "User signed up and logged in through Facebook!");
                        } else {
                            Log.d(TAG, "User logged in through Facebook!");
                            SharedPreferences sharedPreferences = getSharedPreferences(Constants.PREFS_NAME, 0);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString(Constants.LOGIN_FIELD, user.getUsername());
                        }
                    }
                });
                */
                SharedPreferences sharedPreferences = getSharedPreferences(Constants.PREFS_NAME, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Constants.LOGIN_FIELD, "wes");
                finish();
            }
        });
    }
}
