package com.wesleyreisz.notmymusic.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

import com.wesleyreisz.notmymusic.R;
import com.wesleyreisz.notmymusic.fragment.MusicGridFragment;
import com.wesleyreisz.notmymusic.model.Song;

import java.util.List;

/**
 * Created by wesleyreisz on 11/2/14.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private List<Song> mSongList;

    public ImageAdapter(Context c, List<Song> songList) {
        mContext = c;
        mSongList = songList;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(185, 185));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            android.R.drawable.ic_btn_speak_now,android.R.drawable.ic_delete,
            android.R.drawable.ic_dialog_alert, android.R.drawable.ic_dialog_email,
            android.R.drawable.ic_dialog_dialer,android.R.drawable.ic_dialog_map,
            android.R.drawable.ic_input_add,android.R.drawable.ic_lock_idle_alarm,
            android.R.drawable.ic_lock_idle_lock,android.R.drawable.ic_dialog_info,
            android.R.drawable.ic_btn_speak_now,android.R.drawable.ic_delete,
            android.R.drawable.ic_dialog_alert, android.R.drawable.ic_dialog_email,
            android.R.drawable.ic_dialog_dialer,android.R.drawable.ic_dialog_map,
            android.R.drawable.ic_input_add,android.R.drawable.ic_lock_idle_alarm,
            android.R.drawable.ic_lock_idle_lock,android.R.drawable.ic_dialog_info,
            android.R.drawable.ic_btn_speak_now,android.R.drawable.ic_delete,
            android.R.drawable.ic_dialog_alert, android.R.drawable.ic_dialog_email,
            android.R.drawable.ic_dialog_dialer,android.R.drawable.ic_dialog_map,
            android.R.drawable.ic_input_add,android.R.drawable.ic_lock_idle_alarm,
            android.R.drawable.ic_lock_idle_lock,android.R.drawable.ic_dialog_info,
            android.R.drawable.ic_btn_speak_now,android.R.drawable.ic_delete,
            android.R.drawable.ic_dialog_alert, android.R.drawable.ic_dialog_email,
            android.R.drawable.ic_dialog_dialer,android.R.drawable.ic_dialog_map,
            android.R.drawable.ic_input_add,android.R.drawable.ic_lock_idle_alarm,
            android.R.drawable.ic_lock_idle_lock,android.R.drawable.ic_dialog_info,
            android.R.drawable.ic_btn_speak_now,android.R.drawable.ic_delete,
            android.R.drawable.ic_dialog_alert, android.R.drawable.ic_dialog_email,
            android.R.drawable.ic_dialog_dialer,android.R.drawable.ic_dialog_map,
            android.R.drawable.ic_input_add,android.R.drawable.ic_lock_idle_alarm,
            android.R.drawable.ic_lock_idle_lock,android.R.drawable.ic_dialog_info,
            android.R.drawable.ic_btn_speak_now,android.R.drawable.ic_delete,
            android.R.drawable.ic_dialog_alert, android.R.drawable.ic_dialog_email,
            android.R.drawable.ic_dialog_dialer,android.R.drawable.ic_dialog_map,
            android.R.drawable.ic_input_add,android.R.drawable.ic_lock_idle_alarm,
            android.R.drawable.ic_lock_idle_lock,android.R.drawable.ic_dialog_info,
            android.R.drawable.ic_btn_speak_now,android.R.drawable.ic_delete,
            android.R.drawable.ic_dialog_alert, android.R.drawable.ic_dialog_email,
            android.R.drawable.ic_dialog_dialer,android.R.drawable.ic_dialog_map,
            android.R.drawable.ic_input_add,android.R.drawable.ic_lock_idle_alarm,
            android.R.drawable.ic_lock_idle_lock,android.R.drawable.ic_dialog_info,
    };
}
