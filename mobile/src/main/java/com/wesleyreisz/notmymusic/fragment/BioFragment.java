package com.wesleyreisz.notmymusic.fragment;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.echonest.api.v4.Artist;
import com.echonest.api.v4.Biography;
import com.echonest.api.v4.EchoNestException;
import com.wesleyreisz.notmymusic.Constants;
import com.wesleyreisz.notmymusic.GlobalState;
import com.wesleyreisz.notmymusic.R;
import com.wesleyreisz.notmymusic.core.ArtistService;
import com.wesleyreisz.notmymusic.model.ArtistCache;
import com.wesleyreisz.notmymusic.model.Song;
import com.wesleyreisz.notmymusic.util.ArtistUtil;

import java.util.List;

/**
 * Created by wesleyreisz on 11/30/14.
 */
public class BioFragment extends Fragment {
    private static final String TAG = "SONG BIOGRAPHY";
    private GlobalState mGlobalState;
    private TextView textViewBio;
    private TextView textViewSource;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_bio, container, false);
        mGlobalState = GlobalState.getInstance();
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textViewBio = (TextView)getActivity().findViewById(R.id.textViewBiography);
        textViewSource = (TextView)getActivity().findViewById(R.id.textViewSource);

        Bundle extras = getActivity().getIntent().getExtras();
        int position;
        if(extras != null && mGlobalState != null) {
            position = extras.getInt(Constants.POSITION);
            Song song = mGlobalState.getSongList().get(position);
            ArtistCache artistCache = ArtistUtil.findArtist(mGlobalState,song.getArtist());
            if (artistCache!=null){
                //get from cache
                Log.d(TAG, "Getting Artist from Cache");
                textViewBio.setText(artistCache.getBio());
                textViewSource.setText(artistCache.getUrl());
            }else{
                //get from web
                Log.d(TAG, "Getting Artist from Web");
                new FindArtistAsyncTask().execute(song.getArtist());
            }
        }else{
            Log.d(TAG, "No data passed to fragment or global statis null");
        }
    }

    private class FindArtistAsyncTask extends AsyncTask<String, Void, Biography> {

        @Override
        protected Biography doInBackground(String... params) {
            ArtistService artistService = new ArtistService();
            Artist artist = null;
            Biography biography = null;
            try {
                //get the artist
                artist = artistService.findArtistIdByKeywords(params);

                //now get the bios
                List<Biography> biographyList = artist.getBiographies();
                if (biographyList != null && biographyList.size() >= 1) {
                    biography = biographyList.get(0);
                    //if its truncated grab the next
                    if(biography.getText().contains("...") && biographyList.size()>=2){
                        biography = biographyList.get(1);
                    }
                    Log.d(TAG, "Found biography");
                } else {
                    Log.d(TAG, "No biography");
                }
                //cache it
                ArtistCache artistCache = new ArtistCache();
                artistCache.setName(artist.getName());
                artistCache.setBio(biography.getText());
                artistCache.setUrl(biography.getURL());
                ArtistUtil.addArtist(mGlobalState,artistCache);

                return biography;
            } catch (EchoNestException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Biography biography) {
            super.onPostExecute(biography);

            //ArtistUtil.addArtist(mGlobalState, artist);
            Log.d(TAG, "found artist: " + biography.toString());
            if(biography!=null){
                textViewBio.setText(biography.getText());
                textViewSource.setText(biography.getURL());
            }else {
                Log.d(TAG, "No artist found from search");
                textViewBio.setText(Constants.NO_BIOGRAPHY_FOUND);
            }
        }
    }
}
