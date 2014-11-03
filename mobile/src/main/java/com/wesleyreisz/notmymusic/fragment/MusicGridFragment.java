package com.wesleyreisz.notmymusic.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.wesleyreisz.notmymusic.DetailActivity;
import com.wesleyreisz.notmymusic.R;
import com.wesleyreisz.notmymusic.adapter.ImageAdapter;

/**
 * Created by wesleyreisz on 11/2/14.
 */
public class MusicGridFragment extends Fragment {
    GridView gridviewMusic;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_song_grid, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gridviewMusic = (GridView) getActivity().findViewById(R.id.gridviewMusic);
        gridviewMusic.setAdapter(new ImageAdapter(getActivity()));
        gridviewMusic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                startActivity(intent);
            }
        });
    }
}
