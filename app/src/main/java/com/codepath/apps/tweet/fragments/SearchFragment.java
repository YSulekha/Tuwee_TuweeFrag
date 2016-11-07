package com.codepath.apps.tweet.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
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
import com.codepath.apps.tweet.utils.Utility;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

import static com.raizlabs.android.dbflow.sql.language.SQLite.select;

/**
 * Created by aharyadi on 11/7/16.
 */

public class SearchFragment extends TweetsListFragment {
    private TwitterClient twitterClient;

    public static SearchFragment newInstance(String query){
        SearchFragment searchFragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString("query",query);
        searchFragment.setArguments(args);
        return searchFragment;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  super.onCreateView(inflater, container, savedInstanceState);
     /*   endlessScrollViewListener = new EndlessScrollViewListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                populateTimeline(false, false);
            }
        };*/

        //   recyclerView.addOnScrollListener(endlessScrollViewListener);

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

        String query = getArguments().getString("query");

        twitterClient.getSearchresult(query,new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.v("Insidr populateTimelne",response.toString());

                Log.v("getHomeTimeLine",response.toString());
                JSONArray tweetArray = null;
                try {
                    tweetArray = response.getJSONArray("statuses");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if (isRefresh) {
                    tweets.addAll(0, Tweet.fromJSONArray(tweetArray));
                    swipeRefreshLayout.setRefreshing(false);
                } else {
                    tweets.addAll(Tweet.fromJSONArray(tweetArray));

                }
                recyclerAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.v("failure", errorResponse.toString());
            }


        });
    }
}
