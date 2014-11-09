package com.wesleyreisz.notmymusic.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wesleyreisz.notmymusic.Constants;
import com.wesleyreisz.notmymusic.GlobalState;
import com.wesleyreisz.notmymusic.R;

/**
 * Created by wesleyreisz on 10/27/14.
 */
public class DetailsFragment extends Fragment {
    private GlobalState mGlobalState;
    private TextView mTextView;
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
            mTextView = (TextView) getActivity().findViewById(R.id.textViewSongTitle);
            mTextView.setText(mGlobalState.getSongListTopTen().get(position).getTitle());
        }
    }
}

