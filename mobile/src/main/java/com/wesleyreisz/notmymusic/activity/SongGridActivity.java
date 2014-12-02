package com.wesleyreisz.notmymusic.activity;

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

import com.wesleyreisz.notmymusic.GlobalState;
import com.wesleyreisz.notmymusic.R;
import com.wesleyreisz.notmymusic.fragment.AddFragment;
import com.wesleyreisz.notmymusic.fragment.MusicGridFragment;
import com.wesleyreisz.notmymusic.fragment.SearchFragment;
import com.wesleyreisz.notmymusic.listener.MyTabListener;
import com.wesleyreisz.notmymusic.model.ArtistCache;
import com.wesleyreisz.notmymusic.model.Song;

import java.util.ArrayList;
import java.util.HashMap;


public class SongGridActivity extends BaseActivity {

    public static final String MESSAGE_KEY = "message";

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
            case R.id.action_refresh: refresh(); return true;
            case android.R.id.home: home(); return true;

            default : return false;
        }
    }

    private void refresh() {
        GlobalState globalState = GlobalState.getInstance();
        globalState.setSongList(new ArrayList<Song>());
        globalState.setArtistMap(new HashMap<String, ArtistCache>());

        getFragmentManager().beginTransaction()
            .replace(R.id.container, new MusicGridFragment())
            .commit();
    }

    private void home() {
        getFragmentManager().beginTransaction()
            .replace(R.id.container, new MusicGridFragment())
            .commit();
    }


    private void settings() {
        Toast toast = Toast.makeText(this, "Settings", Toast.LENGTH_SHORT);
        toast.show();
    }
}
