package com.example.mcs.weatherapp.UI;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;

import com.example.mcs.weatherapp.Model.WeatherModel;
import com.example.mcs.weatherapp.R;

/***
 * This activity acts a holder for the 2 fragments. It also Sets the toolbar and navigation window
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /***
     * The callback method for when the activity is created
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize toolbar and nav drawer
        init();

        // Add zip search fragment if this is first creation
        if (savedInstanceState == null) {
            Fragment fragment = new ZipSearchFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment, fragment.getTag()).commit();
        }
    }

    // initialize toolbar and nav drawer
    private void init(){
        //Finds and sets the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initializes the Navigation drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    /***
     * method overrides back pressed to say if drawer is open, close it if that event occurs
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /***
     * Overrides method to close drawer when selsections an item
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    /***
     *     Shows the weather fragment for the particular zip, Called when user hits the search button in the search fragment
     */
    public void show(String zip) {

        //creates a new weather fragment
        WeatherFragment weatherFragment = WeatherFragment.forZip(zip);

        //starts the new fragment, places search on backstack
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("search")
                .replace(R.id.fragment_container,
                        weatherFragment, null).commit();

        //Hides soft keyboard
        InputMethodManager inputMethodManager =
                (InputMethodManager) this.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                this.getCurrentFocus().getWindowToken(), 0);
    }

}
