package com.codepath.apps.tweet.fragments;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.codepath.apps.tweet.R;
import com.codepath.apps.tweet.TwitterApplication;
import com.codepath.apps.tweet.TwitterClient;
import com.codepath.apps.tweet.activities.SearchActivity;
import com.codepath.apps.tweet.activities.TwitterDetailActivity;
import com.codepath.apps.tweet.adapters.TweetsArrayAdapter;
import com.codepath.apps.tweet.databinding.FragmentTweetsListBinding;
import com.codepath.apps.tweet.models.Tweet;
import com.codepath.apps.tweet.utils.DividerItemDecoration;
import com.codepath.apps.tweet.utils.EndlessScrollViewListener;
import com.codepath.apps.tweet.utils.ItemClickSupport;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;
import org.parceler.Parcels;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

import static com.codepath.apps.tweet.activities.TimelineActivity.DETAIL_TWEET;


public class TweetsListFragment extends Fragment implements ComposeDialog.SaveFilterListener {

    FragmentTweetsListBinding binding;
     TweetsArrayAdapter recyclerAdapter;
     RecyclerView recyclerView;
     SwipeRefreshLayout swipeRefreshLayout;
     ArrayList<Tweet> tweets;
    EndlessScrollViewListener endlessScrollViewListener;
    LinearLayoutManager linearLayoutManager;
    MenuItem mProgressbar;
    Menu mMenu;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_tweets_list,container,false);
        Log.v("InOnCreateView","sas");
        recyclerView = binding.timelineRecycler;

        swipeRefreshLayout = binding.swipeContainer;
        tweets = new ArrayList<Tweet>();
        recyclerAdapter = new TweetsArrayAdapter(getActivity(), tweets);
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);


        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST);
        recyclerView.addItemDecoration(itemDecoration);
        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent intent = new Intent(v.getContext(), TwitterDetailActivity.class);
                Tweet t = tweets.get(position);
                intent.putExtra("tweet", Parcels.wrap(t));
                startActivityForResult(intent, DETAIL_TWEET);
            }
        });


        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu,inflater);
        mMenu = menu;
        inflater.inflate(R.menu.menu_fragment, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                onTweetSearch(query);
                searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


    }

    private void onTweetSearch(String query) {
            Intent intent = new Intent(getActivity(), SearchActivity.class);
        intent.putExtra("query",query);
        startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Override
    public void onTweet(RequestParams params) {
        TwitterClient twitterClient = TwitterApplication.getRestClient();
        twitterClient.tweetStatus(new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Log.v("HomeTimeLine",response.toString());

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                // Log.v("failure", errorResponse.toString());

            }
        }, params);
    }


    @Override
    public void onPrepareOptionsMenu(Menu menu) {

        // Store instance of the menu item containing progress
        mProgressbar = menu.findItem(R.id.miActionProgress);
        // Extract the action-view from the menu item
        ProgressBar v =  (ProgressBar) MenuItemCompat.getActionView(mProgressbar);
        // Return to finish
        super.onPrepareOptionsMenu(menu);
    }

    }


