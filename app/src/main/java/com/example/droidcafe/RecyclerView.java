package com.example.droidcafe;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.droidcafe.databinding.ActivityRecyclerViewBinding;

import java.util.LinkedList;

public class RecyclerView extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityRecyclerViewBinding binding;
    private final LinkedList<String> mWordList = new LinkedList<>();
    private View mRecyclerView;
    private WordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRecyclerViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.recycler_view);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Get a handle to the RecyclerView
        mRecyclerView = findViewById(R.id.recycler_view);
        //Create an adapter and supply the data to be displayed
        mAdapter = new WordListAdapter(this, mWordList);
        //Connect the adapter with the RecyclerView
        mRecyclerView.setAdapter(mAdapter);
        //Give the RecyclerView a default layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Put initial data into wordlist
        for (int i=0; i<20; i++){
            mWordList.addLast("Word " + 1);
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.recycler_view);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}