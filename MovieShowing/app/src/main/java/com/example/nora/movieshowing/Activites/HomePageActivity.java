package com.example.nora.movieshowing.Activites;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.Service;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridLayout;
import android.widget.Toast;

import com.example.nora.movieshowing.BuildConfig;
import com.example.nora.movieshowing.Model.Movie;
import com.example.nora.movieshowing.Adapter.MoviesAdapter;
import com.example.nora.movieshowing.R;
import com.google.gson.JsonArray;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePageActivity extends AppCompatActivity {

   private RecyclerView recyclerView;
   private   MoviesAdapter adapter;
    private List<Movie>movieList;
    private ProgressDialog pd;
    private SwipeRefreshLayout swipeContainer;
    public static final String  LOG_TAG = MoviesAdapter.class.getName();
   public static final String url_api_key="https://api.themoviedb.org/3/movie/popular?api_key=8b8f975b2825d64c1d0dacd4aa432541";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        initViews();

        swipeContainer=findViewById(R.id.main_content);
        swipeContainer.setColorSchemeResources(android.R.color.holo_orange_dark);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initViews();

                Toast.makeText(HomePageActivity.this,"Movies Refresh",Toast.LENGTH_LONG);
            }
        });


    }


    public Activity getActivity(){
        Context context =this;
        while (context instanceof ContextWrapper){
            if(context instanceof Activity){
                return (Activity) context;
            }
           context =((ContextWrapper)context).getBaseContext();
        }

      return null;
    }

    public void initViews(){
        pd=new ProgressDialog(this);
        pd.setMessage("Fetching Movies...");
        pd.setCancelable(false);
        pd.show();

        recyclerView=findViewById(R.id.recycler_view);
        movieList=new ArrayList<>();
        adapter=new MoviesAdapter(this,movieList);

        if(getActivity().getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT){

            recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        }else{
            recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        }
         recyclerView.setItemAnimator(new DefaultItemAnimator());
         recyclerView.setAdapter(adapter);
         adapter.notifyDataSetChanged();

    }






    public void ionFunc(){

        Ion.with(getApplicationContext())
                .load(url_api_key)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        if(e == null){

                            String myJson = result.toString();
                            if(myJson!=null) {
                                
                            }
                        }else {
                            System.out.println(e.getMessage());
                        }
                    }
                });
    }





}
