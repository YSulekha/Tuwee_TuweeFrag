package com.codepath.apps.tweet.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.codepath.apps.tweet.R;
import com.codepath.apps.tweet.TwitterApplication;
import com.codepath.apps.tweet.TwitterClient;
import com.codepath.apps.tweet.databinding.ActivityProfileBinding;
import com.codepath.apps.tweet.fragments.UserTimeLineFragment;
import com.codepath.apps.tweet.models.User;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;
import org.parceler.Parcels;

import cz.msebera.android.httpclient.Header;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class ProfileActivity extends AppCompatActivity {

    ActivityProfileBinding profileBinding;
    private TwitterClient twitterClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_profile);
        profileBinding = DataBindingUtil.setContentView(this, R.layout.activity_profile);
        Intent intent = getIntent();
        boolean isUser = intent.getBooleanExtra("isUser",false);
        User user = null;
        if(isUser){
            getUserHeader();
        }
        else{
            user = (User) Parcels.unwrap(intent.getParcelableExtra("user"));
            populateProfileHeader(user);
        }

        if(savedInstanceState==null){
            String screenName = null;
            if(user != null){
                screenName = user.getScreenName();
            }
            UserTimeLineFragment userTimeLineFragment = UserTimeLineFragment.newInstance(screenName);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.profile_container,userTimeLineFragment);
            transaction.commit();
        }

    }

    private void populateProfileHeader(User user) {
        getSupportActionBar().setTitle(user.getScreenName());
        ImageView profileImage = profileBinding.profileImage;
        Glide.with(this).load(user.getImageUrl()).bitmapTransform(new RoundedCornersTransformation(profileImage.getContext(),8,0)).
                into(profileImage);
        profileBinding.profileName.setText(user.getUserName());
        profileBinding.profileTagline.setText(user.getTagLine());
        profileBinding.profileFollowing.setText(String.valueOf(user.getFollowing()));
        profileBinding.profileFollowers.setText(String.valueOf(user.getFollowers()));

    }

    private void getUserHeader(){
        twitterClient = TwitterApplication.getRestClient();
        twitterClient.getUserInfo(new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                User user = User.fromJSONObject(response);
                Log.v("ProfileActTagLine",response.toString());
                populateProfileHeader(user);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.v("failure", errorResponse.toString());
            }


        });
    }

}
