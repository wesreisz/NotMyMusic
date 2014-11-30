package com.wesleyreisz.notmymusic;

import com.echonest.api.v4.Artist;
import com.echonest.api.v4.Biography;
import com.echonest.api.v4.EchoNestException;
import com.wesleyreisz.notmymusic.core.ArtistService;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created by wesleyreisz on 11/30/14.
 */
public class ArtistServiceTest extends TestCase {
    public void testFindArtistIdByKeywords(){
        String[] keywords = new String[]{"James Newton Howard", "The Hanging Tree"};
        ArtistService artistService = new ArtistService();
        try {
            Artist artist = artistService.findArtistIdByKeywords(keywords[0]);
            assertNotNull(artist);
            assertEquals("ARSZIBW1187B994053", artist.getID());
            List<Biography> bios = artist.getBiographies();
            assertNotNull(bios);
            if(bios.size()>=1){
                Biography bio = bios.get(0);
                assertTrue(bio.getText().startsWith("James Newton Howard"));
                assertEquals("http://www.last.fm/music/James+Newton+Howard/+wiki",bio.getURL());
            }

        } catch (EchoNestException e) {
            e.printStackTrace();
            assertTrue(e.getMessage(),false);
        }
    }
}
