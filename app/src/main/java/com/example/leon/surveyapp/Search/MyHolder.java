package com.example.leon.surveyapp.Search;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leon.surveyapp.R;

/**
 * Created by Leon on 10/11/2016.
 */


public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    //our VIEWS
    ImageView img;
    TextView nameTxt,posTxt;

    ItemClickListener itemClickListener;

    public MyHolder(View itemView){
        super(itemView);

        this.img = (ImageView) itemView.findViewById(R.id.playerImage);
        this.nameTxt = (TextView) itemView.findViewById(R.id.nameTxt);
        this.posTxt = (TextView) itemView.findViewById(R.id.posTxt);

        itemView.setOnClickListener(this);

    }

    //mislim da ovde radi on click na poziciju u layout-u tj na click u "position"

    //mozda bude problem kod sortiranja niza...
    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic){

        this.itemClickListener = ic;
    }
}
