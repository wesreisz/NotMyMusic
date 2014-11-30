package com.wesleyreisz.notmymusic.util;

import com.echonest.api.v4.Artist;
import com.echonest.api.v4.EchoNestException;
import com.wesleyreisz.notmymusic.GlobalState;
import com.wesleyreisz.notmymusic.model.ArtistCache;

/**
 * Created by wesleyreisz on 11/30/14.
 */
public class ArtistUtil {
    public static ArtistCache findArtist(GlobalState globalState, String artistName){
        return globalState.getArtistMap().get(artistName);
    }
    public static void addArtist(GlobalState globalState, ArtistCache artist) throws EchoNestException {
        globalState.getArtistMap().put(artist.getName(),artist);
    }
}
