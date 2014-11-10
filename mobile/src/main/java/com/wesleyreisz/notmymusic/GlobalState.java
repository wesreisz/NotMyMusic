package com.wesleyreisz.notmymusic;

import android.app.Application;

import com.wesleyreisz.notmymusic.model.Song;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wesleyreisz on 11/2/14.
 */
public class GlobalState extends Application {
    private static GlobalState singleton;

    public static GlobalState getInstance(){
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        singleton.songList = new ArrayList<Song>();
    }

    private List<Song> songList;

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }
}
