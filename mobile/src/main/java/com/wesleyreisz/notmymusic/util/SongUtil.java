package com.wesleyreisz.notmymusic.util;

import com.wesleyreisz.notmymusic.Constants;
import com.wesleyreisz.notmymusic.model.Song;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wesleyreisz on 11/2/14.
 */
public class SongUtil {
    public static List<Song> mapSongs(String inputString){
        List<Song> songs = new ArrayList<Song>();
        try {
            JSONObject json = new JSONObject(inputString);
            JSONObject feedObject = json.getJSONObject("feed");
            JSONArray entryArray = feedObject.getJSONArray("entry");
            for(int i = 0; i < entryArray.length(); i++){
                JSONObject entryObjects = entryArray.getJSONObject(i);

                Song song = new Song();
                song.setTitle(getItem(entryObjects, Constants.RSS_FEED_SONG_NAME));
                song.setArtist(getItem(entryObjects, Constants.RSS_FEED_ARTIST_NAME));
                song.setReleaseDate(getItem(entryObjects, Constants.RSS_FEED_RELEASE_DATE));
                song.setImages(getItems(entryObjects, Constants.RSS_FEED_IMAGES));
                song.setAlbum(getItemFromCollection(entryObjects,Constants.RSS_FEED_COLLECTION,Constants.RSS_FEED_COLLECTION_NAME));

                songs.add(song);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return songs;
    }
    private static String getItem(JSONObject entryObjects, String item) throws JSONException {
        JSONObject nameObject = entryObjects.getJSONObject(item);
        return  nameObject.getString("label");
    }

    private static String getItemFromCollection(JSONObject entryObjects, String collection, String item) throws JSONException {
        JSONObject collectionObject = entryObjects.getJSONObject(collection);
        JSONObject nameObject = collectionObject.getJSONObject(item);
        return  nameObject.getString("label");
    }

    private static String[] getItems(JSONObject entryObjects, String item) throws JSONException {
        JSONArray entryArray = entryObjects.getJSONArray(item);
        String[] strings = new String[entryArray.length()];
        for(int i = 0; i < entryArray.length(); i++){
            JSONObject entryObjectItem = entryArray.getJSONObject(i);
            strings[i]= entryObjectItem.getString("label");
        }
        return strings;
    }
}
