package com.codepath.apps.tweet.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.codepath.apps.tweet.R;
import com.codepath.apps.tweet.adapters.ViewPagerAdapter;
import com.codepath.apps.tweet.databinding.ActivityTimelineBinding;
import com.codepath.apps.tweet.fragments.ComposeDialog;
import com.codepath.apps.tweet.fragments.HomeTimeLineFragment;
import com.codepath.apps.tweet.fragments.TweetsListFragment;
import com.codepath.apps.tweet.utils.Utility;
import com.loopj.android.http.RequestParams;


public class TimelineActivity extends AppCompatActivity implements ComposeDialog.SaveFilterListener  {



    private TweetsListFragment tweetFragment;
    //Applying Data Binding for Views
    ActivityTimelineBinding timelineBinding;
    ViewPager pager;
    ViewPagerAdapter pagerAdapter;

    public static final int DETAIL_TWEET = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        timelineBinding = DataBindingUtil.setContentView(this, R.layout.activity_timeline);
        // setContentView(R.layout.activity_timeline);
        Toolbar toolbar = timelineBinding.toolbar;
        setSupportActionBar(toolbar);
        pager = timelineBinding.contentTimeline.contentPager;
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);

        TabLayout tabLayout = timelineBinding.contentTimeline.contentTab;
        tabLayout.setupWithViewPager(pager);

        FloatingActionButton fab = timelineBinding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Utility.isNetworkAvailable(view.getContext())) {
                    //  Organization_Table.name.is("CodePath")
                    //     tweets.addAll(select().from(Tweet.class).orderBy(Tweet_Table.createdAt,false).queryList());
                    //   recyclerAdapter.notifyDataSetChanged();
                    Toast.makeText(view.getContext(),getResources().getString(R.string.no_network),Toast.LENGTH_LONG).show();
                }
                else {
                    FragmentManager fm = getSupportFragmentManager();
                    ComposeDialog dialog = ComposeDialog.newInstance(null);
                    dialog.show(fm, "Dialog");
                }
            }
        });






        //Configure recycler view




        //Singleton client

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.v("OnActivityResult","dds");
        // Check which request we're responding to
        if (requestCode == DETAIL_TWEET) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
               if(data.getBooleanExtra("is_reply",false)){
                 RequestParams params = data.getParcelableExtra("params");
                 //  onTweet(params);
               }
            }
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_twitter,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }


    public void onProfileView(MenuItem item) {
        Intent i = new Intent(this,ProfileActivity.class);
        i.putExtra("isUser",true);
        startActivity(i);
    }

    private String getFragmentTag(int viewPagerId, int fragmentPosition)
    {
        return "android:switcher:" + viewPagerId + ":" + fragmentPosition;
    }

    @Override
    public void onTweet(RequestParams params) {
        Log.v("Timeline","dddd");
        HomeTimeLineFragment fragment = (HomeTimeLineFragment) pagerAdapter.getRegisteredFragment(0);
        fragment.onTweet(params);
    }
}
