package com.codepath.apps.tweet.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.codepath.apps.tweet.R;
import com.codepath.apps.tweet.databinding.ActivitySearchBinding;
import com.codepath.apps.tweet.fragments.SearchFragment;

/**
 * Created by aharyadi on 11/7/16.
 */

public class SearchActivity extends AppCompatActivity {
   ActivitySearchBinding searchBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchBinding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        Intent intent = getIntent();
        String query = intent.getStringExtra("query");
        SearchFragment searchFragment = SearchFragment.newInstance(query);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.search_container,searchFragment);
        transaction.commit();
    }
}
