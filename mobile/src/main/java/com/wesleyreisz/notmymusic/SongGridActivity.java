package com.wesleyreisz.notmymusic;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Toast;

import com.wesleyreisz.notmymusic.fragment.AddFragment;
import com.wesleyreisz.notmymusic.fragment.MusicGridFragment;
import com.wesleyreisz.notmymusic.fragment.SearchFragment;
import com.wesleyreisz.notmymusic.listener.MyTabListener;


public class SongGridActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_grid);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                .add(R.id.container, new MusicGridFragment())
                .commit();
        }
        getActionBar().setHomeButtonEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_song_grid, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();
        switch (id){
            case R.id.action_settings: settings(); return true;
            case R.id.action_search: search(); return true;
            case R.id.action_add: add(); return true;
            case android.R.id.home: home(); return true;

            default : return false;
        }
    }

    private void home() {
        getFragmentManager().beginTransaction()
                .replace(R.id.container, new MusicGridFragment())
                .commit();
    }

    private void add() {
        getFragmentManager().beginTransaction()
            .replace(R.id.container, new AddFragment())
            .commit();
    }

    private void search() {
        getFragmentManager().beginTransaction()
            .replace(R.id.container, new SearchFragment())
            .commit();
    }

    private void settings() {
        Toast toast = Toast.makeText(this, "Settings", Toast.LENGTH_SHORT);
        toast.show();
    }
}
