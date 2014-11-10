package com.wesleyreisz.notmymusic.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wesleyreisz.notmymusic.Constants;
import com.wesleyreisz.notmymusic.GlobalState;
import com.wesleyreisz.notmymusic.R;
import com.wesleyreisz.notmymusic.model.Song;

/**
 * Created by wesleyreisz on 10/27/14.
 */
public class DetailsFragment extends Fragment {
    private GlobalState mGlobalState;
    private int position;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_details, container, false);
        mGlobalState = GlobalState.getInstance();
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle extras = getActivity().getIntent().getExtras();
        if(extras != null && mGlobalState != null){
            position = extras.getInt(Constants.POSITION);
            Song song = mGlobalState.getSongList().get(position);
            TextView songTitle = (TextView) getActivity().findViewById(R.id.textViewSongTitle);
            songTitle.setText(song.getTitle());

            ImageView imageView = (ImageView) getActivity().findViewById(R.id.imageViewDetail);
            imageView.setImageBitmap(song.getImage());

            TextView songArtist = (TextView) getActivity().findViewById(R.id.textViewDetailArtistName);
            songArtist.setText(song.getArtist());

            TextView songReleaseDate = (TextView) getActivity().findViewById(R.id.textViewDetailReleaseDate);
            songReleaseDate.setText(song.getReleaseDate());

            TextView albumName = (TextView) getActivity().findViewById(R.id.textViewDetailAlbumName);
            albumName.setText(song.getAlbum());

        }
    }
}

