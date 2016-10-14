package com.example.leon.surveyapp.Controller;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.leon.surveyapp.Api.ApiActivity;
import com.example.leon.surveyapp.Fragments.AboutFragment;
import com.example.leon.surveyapp.Fragments.HomeFragment;
import com.example.leon.surveyapp.R;
import com.example.leon.surveyapp.Search.SearchActivity;


public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //changing icon of SETTINGS
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.set2);
        toolbar.setOverflowIcon(drawable);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        Fragment fragment = null;
        Class fragmentClass = HomeFragment.class;


        if (id == R.id.nav_home) {
            Toast.makeText(this,"Home Clicked",Toast.LENGTH_SHORT).show();

            fragmentClass = HomeFragment.class;


        } else if (id == R.id.nav_my_surveys) {
            Toast.makeText(this,"My Surveys Clicked",Toast.LENGTH_SHORT).show();


            Intent intent = new Intent(this, TestActivity.class);
            startActivity(intent);


            /*fragmentClass = BlankJEBENIFragment.class;*/

            /*HomeFragment homeFragment = new HomeFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(
                    R.id.flContent,
                    homeFragment,
                    homeFragment.getTag()).commit();*/

            /*findViewById(R.id.relativelayout_for_fragment).setVisibility(View.GONE);*/



        } else if (id == R.id.nav_search) {
            /*Intent intent = new Intent(this, TestActivity.class);
            startActivity(intent);*/

            Intent intent = new Intent(this, SearchActivity.class);
            startActivity(intent);

            /*HomeFragment homeFragment = new HomeFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(
                    R.id.relativelayout_for_fragment,
                    homeFragment,
                    homeFragment.getTag()).commit();*/

        } else if (id == R.id.nav_share) {
            Toast.makeText(this,"nav_share Clicked",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_send) {
            Toast.makeText(this,"nav_send Clicked",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_about) {
            Toast.makeText(this,"nav_about Clicked",Toast.LENGTH_SHORT).show();
            fragmentClass = AboutFragment.class;

        } else if (id == R.id.nav_help) {
            Toast.makeText(this,"nav_help Clicked",Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, ApiActivity.class);
            startActivity(intent);

        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    /*In your Fragment or Activity you have to inflate this menu xml like usual,
    then you can look for the MenuItem which contains the SearchView and implement the OnQueryTextListener
    which we are going to use to listen for changes to the text entered into the SearchView: */


}
