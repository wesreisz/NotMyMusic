package com.wesleyreisz.notmymusic.adapter;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.wesleyreisz.notmymusic.R;
import com.wesleyreisz.notmymusic.fragment.MusicGridFragment;
import com.wesleyreisz.notmymusic.model.Song;

import java.util.List;

/**
 * Created by wesleyreisz on 11/2/14.
 */
public class SongGridViewAdapter extends BaseAdapter {
    private Context mContext;
    private int mLayoutResourceId;
    private List<Song> mSongList;

    public SongGridViewAdapter(Context c, int layoutResourceId, List<Song> songList) {
        mContext = c;
        mLayoutResourceId = layoutResourceId;
        mSongList = songList;
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

        textView = (TextView) item.findViewById(R.id.item_song_text);
        textView.setText((position + 1) + ".) " + mSongList.get(position).getTitle());

        textView = (TextView) item.findViewById(R.id.item_artist_text);
        textView.setText(mSongList.get(position).getArtist());

        return item;
    }

}
