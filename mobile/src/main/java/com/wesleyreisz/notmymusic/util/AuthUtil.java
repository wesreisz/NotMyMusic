package com.wesleyreisz.notmymusic.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;
import com.wesleyreisz.notmymusic.Constants;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wesleyreisz on 12/3/14.
 */
public class AuthUtil {
    private static final String TAG = "SONG AUTHUTIL";
    //private static final String KEY = Constants.PREFS_NAME + "." + Constants.LOGIN_FIELD;

    public static boolean isLoggedIn(Activity activity){
        //if(ParseFacebookUtils.getSession()!=null){
        //    isLoggedIn=true;
        //}

        SharedPreferences sharedPreferences =
                activity.getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE);

        String uid = sharedPreferences.getString(Constants.LOGIN_FIELD,"");

        if(uid!=null && uid.length()>0){
            return true;
        }else{
            return false;
        }

    }

    public static void loginUser(Activity activity, String userId){
        savePreferences(activity,Constants.LOGIN_FIELD,userId);
    }

    public static void logoutUser(Activity activity){
        savePreferences(activity,Constants.LOGIN_FIELD,"");
    }

    private static void savePreferences(Activity activity, String key, String value){
        SharedPreferences preferences =
                activity.getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }
}
