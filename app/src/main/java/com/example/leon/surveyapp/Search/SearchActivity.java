package com.example.leon.surveyapp.Search;

/**
 * Created by Leon on 10/11/2016.
 */
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import com.example.leon.surveyapp.R;

public class SearchActivity extends AppCompatActivity {

    SearchView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Leon-Search");
        //getSupportActionBar().setSubtitle("This is my Subtitle");
        //getSupportActionBar().setIcon(R.drawable.ic_menu_gallery);


        //OVAJ DEO MI JE STO POKUSAVAM DA RADI PNE PREKO QUERY TEXT LISTENERA NEGO PREKO OVOG INTENTA BUDJAVOG
        Intent searchIntent = getIntent();
        if (Intent.ACTION_SEARCH.equals(searchIntent.getAction())) {

            String query = searchIntent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(SearchActivity.this, query, Toast.LENGTH_SHORT).show();
        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        /*sv = (SearchView) findViewById(R.id.mSearch);

        RecyclerView rv = (RecyclerView) findViewById(R.id.myRecycler);

        //SET ITS PROPERTIES
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());

        //ADAPTER
        final MyAdapter adapter = new MyAdapter(this, getPlayers());
        rv.setAdapter(adapter);*/

        //SEARCH
        /*sv.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                //FILTER AS YOU TYPE
                adapter.getFilter().filter(query);

                return false;
            }
        });*/
    }

    //ADD PLAYERS TO ARRAYLIST

    private ArrayList<Player> getPlayers(){

        ArrayList<Player> players =  new ArrayList<>();

        Player p = new Player();
        p.setName("Ander Herera");
        p.setPos("Midfielder");
        p.setImg(R.drawable.circle1);
        players.add(p);

        p = new Player();
        p.setName("Bouqi");
        p.setPos("Niggaa Nigga");
        p.setImg(R.drawable.circle2);
        players.add(p);

        p = new Player();
        p.setName("Leon");
        p.setPos("Nigga²");
        p.setImg(R.drawable.circle3);
        players.add(p);

        p = new Player();
        p.setName("Leon2");
        p.setPos("Nigga2²");
        p.setImg(R.drawable.circle3);
        players.add(p);

        p = new Player();
        p.setName("Kikis");
        p.setPos("Likus");
        p.setImg(R.drawable.circle4);
        players.add(p);

        p = new Player();
        p.setName("Mrnjau");
        p.setPos("Prnjau");
        p.setImg(R.drawable.circle5);
        players.add(p);

        p = new Player();
        p.setName("Mrnjau2");
        p.setPos("Prnjau");
        p.setImg(R.drawable.circle5);
        players.add(p);

        p = new Player();
        p.setName("Mrnjau3");
        p.setPos("Prnjau");
        p.setImg(R.drawable.circle5);
        players.add(p);

        return players;

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);


        //OVAJ DEO MI JE STO POKUSAVAM DA RADI PNE PREKO QUERY TEXT LISTENERA NEGO PREKO OVOG INTENTA BUDJAVOG
        SearchView searchView = (SearchView) menu.findItem(R.id.mSearch2).getActionView();
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));


        RecyclerView rv = (RecyclerView) findViewById(R.id.myRecycler);

        //SET ITS PROPERTIES
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());

        //ADAPTER
        final MyAdapter adapter = new MyAdapter(this, getPlayers());
        rv.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                //FILTER AS YOU TYPE
                adapter.getFilter().filter(query);

                return false;
            }
        });

        // Retrieve the SearchView and plug it into SearchManager
        /*final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.mSearch));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));*/

        return super.onCreateOptionsMenu(menu);
        //return true;
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
}

