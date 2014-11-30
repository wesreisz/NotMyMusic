package com.wesleyreisz.notmymusic;

import android.app.Application;

import com.echonest.api.v4.Artist;
import com.wesleyreisz.notmymusic.model.ArtistCache;
import com.wesleyreisz.notmymusic.model.Song;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        singleton.artistMap = new HashMap<String, ArtistCache>();
    }

    private List<Song> songList;
    private Map<String, ArtistCache> artistMap;

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public Map<String, ArtistCache> getArtistMap() {
        return artistMap;
    }

    public void setArtistMap(Map<String, ArtistCache> artistMap) {
        this.artistMap = artistMap;
    }
}
