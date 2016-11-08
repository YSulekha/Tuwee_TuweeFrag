package com.codepath.apps.tweet.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codepath.apps.tweet.R;
import com.codepath.apps.tweet.TwitterApplication;
import com.codepath.apps.tweet.TwitterClient;
import com.codepath.apps.tweet.models.Tweet;
import com.codepath.apps.tweet.models.Tweet_Table;
import com.codepath.apps.tweet.utils.EndlessScrollViewListener;
import com.codepath.apps.tweet.utils.Utility;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

import static com.loopj.android.http.AsyncHttpClient.log;
import static com.raizlabs.android.dbflow.sql.language.SQLite.select;

public class UserTimeLineFragment extends TweetsListFragment {
    private TwitterClient twitterClient;
    private long sinceId = 0;
    private long maxId = 0;

    public static UserTimeLineFragment newInstance(String screenName){
        UserTimeLineFragment userTimeLineFragment = new UserTimeLineFragment();
        Bundle args = new Bundle();
        args.putString("screen_name",screenName);
        userTimeLineFragment.setArguments(args);
        return userTimeLineFragment;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  super.onCreateView(inflater, container, savedInstanceState);
       endlessScrollViewListener = new EndlessScrollViewListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                populateTimeline(false, false);
            }
        };

           recyclerView.addOnScrollListener(endlessScrollViewListener);

        twitterClient = TwitterApplication.getRestClient();
        if (!Utility.isNetworkAvailable(getActivity())) {
            //  Organization_Table.name.is("CodePath")
            tweets.addAll(select().from(Tweet.class).orderBy(Tweet_Table.createdAt,false).queryList());
            recyclerAdapter.notifyDataSetChanged();
            Toast.makeText(getActivity(),getResources().getString(R.string.no_internet),Toast.LENGTH_LONG).show();
        } else {
            //populate timeline
            populateTimeline(true, false);
        }

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                populateTimeline(true, true);
            }
        });
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }
    //Method to fetch the tweets to populate timeline
    private void populateTimeline(boolean isFirstTime, final boolean isRefresh) {
        RequestParams params = new RequestParams();
        params.put("count", 25);
        //max id not required for first request
        if (!isFirstTime) {
            params.put("max_id", maxId);
        }
        //since id required only for refresh
        if (isRefresh) {
            params.put("since_id", sinceId);
        } else {
            params.put("since_id", 1);
        }

        String screenName = getArguments().getString("screen_name");
        params.put("screen_name",screenName);

        twitterClient.getUserTimeline(new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                Log.v("Insidr populateTimelne",response.toString());
                if (isRefresh) {
                    tweets.addAll(0, Tweet.fromJSONArray(response));
                    swipeRefreshLayout.setRefreshing(false);
                } else {
                    tweets.addAll(Tweet.fromJSONArray(response));

                }
                maxId = tweets.get(tweets.size() - 1).getTweetId() - 1;
                sinceId = tweets.get(0).getTweetId();
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.v("failure", errorResponse.toString());
            }


        },params);
    }

}
