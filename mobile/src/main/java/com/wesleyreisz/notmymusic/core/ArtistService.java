package com.wesleyreisz.notmymusic.core;

import com.echonest.api.v4.Artist;
import com.echonest.api.v4.EchoNestAPI;
import com.echonest.api.v4.EchoNestException;
import com.wesleyreisz.notmymusic.Constants;

import java.util.List;

/**
 * Created by wesleyreisz on 11/30/14.
 */
public class ArtistService {
    public Artist findArtistIdByKeywords(String... inputs) throws EchoNestException {
        EchoNestAPI echoNest = new EchoNestAPI(Constants.ECHO_NEST_KEY);
        String inputString = "";
        for(String input : inputs){
            inputString += input;
        }
        List<Artist> artists = echoNest.searchArtists(inputString);
        return artists.get(0);//return first artist found
    }
}
