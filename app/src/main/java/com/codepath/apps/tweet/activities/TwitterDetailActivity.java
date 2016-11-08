package com.codepath.apps.tweet.activities;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.codepath.apps.tweet.R;
import com.codepath.apps.tweet.TwitterApplication;
import com.codepath.apps.tweet.TwitterClient;
import com.codepath.apps.tweet.databinding.ActivityTwitterDetailBinding;
import com.codepath.apps.tweet.fragments.ComposeDialog;
import com.codepath.apps.tweet.fragments.TweetsListFragment;
import com.codepath.apps.tweet.models.Tweet;
import com.codepath.apps.tweet.utils.Utility;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;
import org.parceler.Parcels;

import cz.msebera.android.httpclient.Header;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class TwitterDetailActivity extends AppCompatActivity implements ComposeDialog.SaveFilterListener {

    ActivityTwitterDetailBinding binding;
    private ComposeDialog.SaveFilterListener listener;
    Tweet t;
    Boolean isReply=false;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_twitter_detail);

        t = (Tweet)Parcels.unwrap(getIntent().getParcelableExtra("tweet"));
        binding.detailBody.setText(t.getBody());
        binding.detailName.setText(t.getUser().getUserName());
        binding.detailScreenname.setText(t.getUser().getScreenName());
        Glide.with(this).load(t.getUser().getImageUrl()).into(binding.detailProfile);
        binding.detailTime.setText(timeCalc(t.getCreatedAt()));
        if(t.isFavorited()){
            DrawableCompat.setTint(binding.detailFavorite.getDrawable(), ContextCompat.getColor(this, android.R.color.holo_red_dark));
        }
        binding.detailFavoriteText.setText(String.valueOf(t.getFavoritedCount()));
        binding.detailRetweetText.setText(String.valueOf(t.getRetweetCount()));
        if(t.getMediaUrl() !=null){
            Glide.with(this).load(t.getMediaUrl()).bitmapTransform(new RoundedCornersTransformation(this,8,0)).into(binding.detailMedia);
        }
        else{
            binding.detailMedia.setImageResource(0);
        }
        intent = new Intent();

    }

    @Override
    protected void onPause() {
        super.onPause();
        setResult(RESULT_OK, intent);
    }

    public void onClickReply(View v){
        isReply = true;
        FragmentManager fm = getSupportFragmentManager();
        Bundle args = new Bundle();
        args.putBoolean("reply",true);
        args.putString("userId",t.getUser().getScreenName());
        args.putLong("tweetid",t.getTweetId());
        ComposeDialog dialog = ComposeDialog.newInstance(args);
        dialog.show(fm, "Dialog");
    }

    public void onClickRetweet(View v){
        Log.v("onretweet","dsfsf");
        TwitterClient twitterClient = TwitterApplication.getRestClient();
        RequestParams params = new RequestParams();
        params.put("id",t.getTweetId());
        final Context context = v.getContext();
        twitterClient.retweet(new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Toast.makeText(context,getResources().getString(R.string.retweeted_success),Toast.LENGTH_SHORT).show();
                Log.v("onSuccessRetweet","dsf");

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.v("failure", errorResponse.toString());
            }


        },params);
    }

    public void onClickFavorite(View v){
        Log.v("onFavorite","dsfsf");
        TwitterClient twitterClient = TwitterApplication.getRestClient();
        RequestParams params = new RequestParams();
        params.put("id",t.getTweetId());
        final Context context = v.getContext();
        twitterClient.favorite(new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                DrawableCompat.setTint(binding.detailFavorite.getDrawable(), ContextCompat.getColor(context, android.R.color.holo_red_dark));
                int x = Integer.parseInt(t.getFavoritedCount())+1;
                t.setFavoritedCount(String.valueOf(x));
                binding.detailFavoriteText.setText(String.valueOf(t.getFavoritedCount()+1));
                //    binding.detailFavorite.set
              //  Toast.makeText(context,getResources().getString(R.string.retweeted_success),Toast.LENGTH_SHORT).show();
                Log.v("onSuccessRetweet","dsf");

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.v("failure", errorResponse.toString());
            }


        },params);
    }

    public static String timeCalc(String createdAt){

        //"created_at":"Mon Oct 31 14:20:57 +0000 2016"
        String relativeDate = Utility.relativeTime(createdAt);
        String d = Utility.formatDate(createdAt);
        return d;

    }
    public static void loadImage(ImageView imageView, String url){
        //    Picasso.with(imageView.getContext()).load(url).placeholder(R.color.colorPrimary).
        //      // into(imageView);
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    @Override
    public void onTweet(RequestParams params) {
        Log.v("DetailOnTweet","dd");
        isReply = true;
        TweetsListFragment fragment = new TweetsListFragment();
        fragment.onTweet(params);
    }
}
