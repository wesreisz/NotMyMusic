package com.wesleyreisz.notmymusic.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.wesleyreisz.notmymusic.Constants;
import com.wesleyreisz.notmymusic.GlobalState;
import com.wesleyreisz.notmymusic.R;
import com.wesleyreisz.notmymusic.model.Song;
import com.wesleyreisz.notmymusic.model.events.ArtistEvents;
import com.wesleyreisz.notmymusic.model.events.Event;
import com.wesleyreisz.notmymusic.util.HttpUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by wesleyreisz on 10/27/14.
 */
public class EventsFragment extends Fragment {
    private static final String TAG = "SONG MAP";
    private GoogleMap map;
    private GlobalState mGlobalState;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        mGlobalState = GlobalState.getInstance();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle extras = getActivity().getIntent().getExtras();
        int position = 0;
        if(extras != null && mGlobalState != null) {
            position = extras.getInt(Constants.POSITION);
            Song song = mGlobalState.getSongList().get(position);

            String encode_url = "";
            try {
                encode_url =  URLEncoder.encode(song.getArtist(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }


            new ListEventsAsyncTask(getActivity()).execute(
                    String.format(Constants.FIND_EVENTS_BY_ARTIST_URL,encode_url)
            );

        }

        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.mapEvents)).getMap();
    }

    @Override
    public void onStop() {
        super.onStop();
        MapFragment f = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.mapEvents);
        if (f != null)
            getFragmentManager().beginTransaction().remove(f).commit();
    }

    private class ListEventsAsyncTask extends AsyncTask<String, Void, ArtistEvents> {
        private Context context;
        public ListEventsAsyncTask(Context context){
            this.context=context;
        }
        @Override
        protected ArtistEvents doInBackground(String... url) {
            Log.d(TAG, url[0]);
            String json = HttpUtil.getJson(url[0]);
            Log.d(TAG,json);

            ObjectMapper mapper = new ObjectMapper();
            ArtistEvents events = null;
            try {
                events = mapper.readValue(json, ArtistEvents.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return events;
        }

        @Override
        protected void onPostExecute(ArtistEvents artistEvents) {
            if (artistEvents!=null && artistEvents.getEvents().size()>0) {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                List<Event> events =  artistEvents.getEvents();

                for(Event event:events){
                    LatLng latLng =  new LatLng(
                            event.getVenue().getLocation().getLat(),
                            event.getVenue().getLocation().getLon()
                    );

                    MarkerOptions marker = new MarkerOptions();
                    marker.position(latLng);
                    marker.title(event.getVenue().getDisplayLocation());
                    marker.snippet(event.getShortTitle());
                    map.addMarker(marker);

                    builder.include(marker.getPosition());
                }

                int padding = 20; // offset from edges of the map in pixels
                LatLngBounds bounds = builder.build();
                CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
                map.animateCamera(cu);

            } else {
                Toast.makeText(
                        context, "No Events found for Artist", Toast.LENGTH_LONG)
                        .show();
            }
        }
    }
}
