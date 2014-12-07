package com.wesleyreisz.notmymusic.util;

/**
 * Created by wesleyreisz on 12/7/14.
 */
public class StringUtil {
    public static String buildTopTenListUrl(String url, String param){
        return String.format(url,param);
    }
}
