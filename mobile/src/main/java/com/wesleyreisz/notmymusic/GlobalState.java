package com.wesleyreisz.notmymusic;

import android.app.Application;

import com.wesleyreisz.notmymusic.model.Song;

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
    }

    private List<Song> songListTopTen;

    public List<Song> getSongListTopTen() {
        return songListTopTen;
    }

    public void setSongListTopTen(List<Song> songListTopTen) {
        this.songListTopTen = songListTopTen;
    }
}
