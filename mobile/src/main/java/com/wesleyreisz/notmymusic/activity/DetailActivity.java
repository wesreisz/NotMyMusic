package com.wesleyreisz.notmymusic.activity;

import android.app.Activity;
import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.wesleyreisz.notmymusic.R;
import com.wesleyreisz.notmymusic.fragment.DetailsFragment;
import com.wesleyreisz.notmymusic.fragment.EventsFragment;
import com.wesleyreisz.notmymusic.fragment.MoreSongsFragment;
import com.wesleyreisz.notmymusic.listener.MyTabListener;


public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);

        ActionBar actionbar = getActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab1 = actionbar.newTab().setText("Details");
        tab1.setTabListener(new MyTabListener(this,new DetailsFragment()));
        actionbar.addTab(tab1);

        ActionBar.Tab tab2 = actionbar.newTab().setText("More Music");
        tab2.setTabListener(new MyTabListener(this, new MoreSongsFragment()));
        actionbar.addTab(tab2);

        ActionBar.Tab tab3 = actionbar.newTab().setText("Events");
        tab3.setTabListener(new MyTabListener(this, new EventsFragment()));
        actionbar.addTab(tab3);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
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
            case android.R.id.home: NavUtils.navigateUpFromSameTask(this); return true;
            default : return false;
        }

        //return super.onOptionsItemSelected(item);
    }

    private void settings() {
        Toast toast = Toast.makeText(this, "Settings", Toast.LENGTH_SHORT);
        toast.show();
    }
}
