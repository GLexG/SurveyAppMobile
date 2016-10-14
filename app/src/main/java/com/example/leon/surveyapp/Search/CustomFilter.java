package com.example.leon.surveyapp.Search;

import android.widget.Filter;

import java.util.ArrayList;

/**
 * Created by Leon on 10/11/2016.
 */
public class CustomFilter extends Filter{

    MyAdapter adapter;
    ArrayList<Player> filterList;


    public CustomFilter(ArrayList<Player> filterList,MyAdapter adapter){
        this.adapter = adapter;
        this.filterList = filterList;


    }


    //FILTERING OCURS
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        //CHECK CONSTRAINT VALIDITY
        if(constraint!=null && constraint.length() >0){
            //CHANGE TO UUUPPER
            constraint = constraint.toString().toUpperCase();

            //STORE OUT FILTERED PLAYERS
            ArrayList<Player> filteredPlayers = new ArrayList<>();

            for(int i=0;i<filterList.size();i++){

                //CHECK
                if(filterList.get(i).getName().toUpperCase().contains(constraint)){

                    //ADD PLAYERS TO FILTERED PLAYERS
                    filteredPlayers.add(filterList.get(i));
                }
            }

            results.count = filteredPlayers.size();
            results.values=filteredPlayers;
        }else{
            results.count = filterList.size();
            results.values = filterList;

        }

        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        adapter.players= (ArrayList<Player>) results.values;

        //REFRESH
        adapter.notifyDataSetChanged();
    }
}
