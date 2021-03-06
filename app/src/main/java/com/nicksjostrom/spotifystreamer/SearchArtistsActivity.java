package com.nicksjostrom.spotifystreamer;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import kaaes.spotify.webapi.android.models.Track;

public class SearchArtistsActivity extends AppCompatActivity  {

    // made this static so we can access it from the player without having to make a new request when forward or previous is pressed
    // needs to be in SearchArtistsActivity so we can access it from our Master-Detail layout as well
    public static ArrayList<Track> trackList = new ArrayList<>();

    public static final String TRACK_INDEX = "com.nicksjostrom.spotifystreamer.TRACK_INDEX";
    public static final String SELECTED_ARTIST_NAME = "com.nicksjostrom.spotifystreamer.SELECTED_ARTIST_NAME";
    public static final String SELECTED_ARTIST_ID = "com.nicksjostrom.spotifystreamer.SELECTED_ARTIST_ID";

    public static boolean mDualPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_artists);

        if(findViewById(R.id.track_list_container) != null) {
            mDualPane = true;
        }

        //if(savedInstanceState != null) {
        //    trackList = (ArrayList) savedInstanceState.getSerializable("trackList");
        //}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_artists, menu);
        return true;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        //savedInstanceState.putSerializable("trackList", trackList);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
