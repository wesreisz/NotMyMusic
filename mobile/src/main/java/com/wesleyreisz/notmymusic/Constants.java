package com.wesleyreisz.notmymusic;

/**
 * Created by wesleyreisz on 11/2/14.
 */
public class Constants {
    public static final String APP = "NOT_MY_MUSIC";

    public static final String HTTPS_ITUNES_APPLE_COM_US_RSS_TOPSONGS =
            "https://itunes.apple.com/us/rss/topsongs/limit=100/json";
    public static final String RSS_FEED_SONG_NAME = "im:name";
    public static final String RSS_FEED_ARTIST_NAME = "im:artist";
    public static final String RSS_FEED_RELEASE_DATE = "im:releaseDate";
    public static final String RSS_FEED_IMAGES = "im:image";
    public static final String RSS_FEED_COLLECTION = "im:collection";
    public static final String RSS_FEED_COLLECTION_NAME = "im:name";

    public static final String GETTING_ITUNES_MESSAGE = "Getting ITunes Top 10";
    public static final String NO_CONNECTION_MESSAGE="No Data Found. Check network connection.";

    public static final String POSITION = "position";
    public static final int TREAD_POOL_SIZE = 10;
}
