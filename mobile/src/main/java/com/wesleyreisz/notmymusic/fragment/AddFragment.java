package com.wesleyreisz.notmymusic.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wesleyreisz.notmymusic.R;

/**
 * Created by wesleyreisz on 10/27/14.
 */
public class AddFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_new, container, false);
        return rootView;
    }
}
