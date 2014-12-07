package com.wesleyreisz.notmymusic.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.wesleyreisz.notmymusic.Constants;
import com.wesleyreisz.notmymusic.activity.DetailActivity;
import com.wesleyreisz.notmymusic.GlobalState;
import com.wesleyreisz.notmymusic.R;
import com.wesleyreisz.notmymusic.adapter.SongGridViewAdapter;
import com.wesleyreisz.notmymusic.model.Song;
import com.wesleyreisz.notmymusic.util.HttpUtil;
import com.wesleyreisz.notmymusic.util.SongUtil;
import com.wesleyreisz.notmymusic.util.StringUtil;

import java.util.List;

/**
 * Created by wesleyreisz on 11/2/14.
 */
public class MusicGridFragment extends Fragment {
    private static final String TAG = "MusicGrid";
    private GlobalState globalState;
    private GridView gridviewMusic;
    private TextView mMessages;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        globalState = GlobalState.getInstance();
        return inflater.inflate(R.layout.fragment_song_grid, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gridviewMusic = (GridView) getActivity().findViewById(R.id.gridviewMusic);
        mMessages = (TextView) getActivity().findViewById(R.id.txtViewMessage);

        if (globalState.getSongList().size()<=0) {
            Log.d(TAG, Constants.GETTING_ITUNES_MESSAGE);
            SharedPreferences sp =  PreferenceManager.getDefaultSharedPreferences(getActivity());
            String url = StringUtil.buildTopTenListUrl(Constants.HTTPS_ITUNES_APPLE_COM_US_RSS_TOPSONGS, sp.getString("numberOfItems", "10"));
            new GetITunesTopTenAsyncTask().execute(url);
        }else{
            populateGridView(globalState.getSongList());
        }
    }

    private class GetITunesTopTenAsyncTask extends AsyncTask<String, Void, String>{

        @Override
        protected void onPreExecute() {
            Toast toast = Toast.makeText(getActivity(), Constants.GETTING_ITUNES_MESSAGE, Toast.LENGTH_SHORT);
            toast.show();
        }

        @Override
        protected String doInBackground(String... params) {
            if(params[0]!=null){
                return HttpUtil.getJson(params[0]);
            }else{
                return "Invalid No url provided";
            }
        }

        @Override
        protected void onPostExecute(String strJson) {
            Log.d(Constants.APP, strJson);
            List<Song> songList = SongUtil.mapSongs(strJson);
            globalState.setSongList(songList);
            populateGridView(songList);
        }
    }

    private void populateGridView(List<Song> songList) {
        if(songList.size()<=0){
            mMessages.setText(Constants.NO_CONNECTION_MESSAGE);
            Toast toast = Toast.makeText(getActivity(),Constants.NO_CONNECTION_MESSAGE, Toast.LENGTH_SHORT);
            toast.show();
        }
        gridviewMusic.setAdapter(
                new SongGridViewAdapter(getActivity(), R.layout.item_grid, songList)
        );
        gridviewMusic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(Constants.POSITION, position);
                startActivity(intent);
            }
        });
    }
}
