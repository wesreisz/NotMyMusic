package com.wesleyreisz.notmymusic.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wesleyreisz.notmymusic.Constants;
import com.wesleyreisz.notmymusic.R;
import com.wesleyreisz.notmymusic.model.ImageContainer;
import com.wesleyreisz.notmymusic.model.ImageSize;
import com.wesleyreisz.notmymusic.model.Song;
import com.wesleyreisz.notmymusic.util.HttpUtil;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wesleyreisz on 11/2/14.
 */
public class SongGridViewAdapter extends BaseAdapter {
    private static final String TAG = "Adapter";
    private Context mContext;
    private int mLayoutResourceId;
    private List<Song> mSongList;
    private HashMap views;

    final Handler imageHandler = new android.os.Handler(){
        public void handleMessage(Message msg){
            Integer position = (Integer)msg.obj;
            Log.d(TAG,"Got Image Position: " + position.toString());
            ImageView view = (ImageView) views.get(position.toString());
            Song song = mSongList.get(position);
            view.setImageBitmap(song.getImage());
        }
    };

    public SongGridViewAdapter(Context c, int layoutResourceId, List<Song> songList) {
        mContext = c;
        mLayoutResourceId = layoutResourceId;
        mSongList = songList;
        views = new HashMap();
    }

    public int getCount() {
        return mSongList.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;

        if(item==null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            item = inflater.inflate(mLayoutResourceId, parent, false);
        }

        ImageView imageView;
        TextView textView;

        imageView = (ImageView) item.findViewById(R.id.item_image);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.drawable.placeholder);

        //create a hashmap of these views so I can update after the thread completes
        views.put(String.valueOf(position), imageView);

        textView = (TextView) item.findViewById(R.id.item_song_text);
        textView.setText((position + 1) + ".) " + mSongList.get(position).getTitle());

        textView = (TextView) item.findViewById(R.id.item_artist_text);
        textView.setText(mSongList.get(position).getArtist());

        String imageToDownload = mSongList.get(position).getImages()[ImageSize.LARGE];

        if (imageToDownload!=null && imageToDownload.length()>0){
            new Thread(new DownloadImages(imageToDownload,position)).start();
        }

        return item;
    }

    private class DownloadImages implements Runnable {
        String url;
        int pos;
        public DownloadImages(String url, int pos){
            this.url = url;
            this.pos = pos;
        }

        @Override
        public void run() {
            Bitmap image = HttpUtil.fetchImage(url);
            Message msg = Message.obtain();
            mSongList.get(pos).setImage(image);
            msg.obj = Integer.valueOf(pos);
            imageHandler.sendMessage(msg);
        }
    }

}
