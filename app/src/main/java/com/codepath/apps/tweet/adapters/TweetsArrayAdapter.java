package com.codepath.apps.tweet.adapters;

import android.content.Context;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.tweet.R;
import com.codepath.apps.tweet.TwitterApplication;
import com.codepath.apps.tweet.TwitterClient;
import com.codepath.apps.tweet.activities.ProfileActivity;
import com.codepath.apps.tweet.activities.SearchActivity;
import com.codepath.apps.tweet.databinding.ContentItemBinding;
import com.codepath.apps.tweet.fragments.ComposeDialog;
import com.codepath.apps.tweet.models.Tweet;
import com.codepath.apps.tweet.models.User;
import com.codepath.apps.tweet.utils.PatternEditableBuilder;
import com.codepath.apps.tweet.utils.Utility;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.yqritc.scalablevideoview.ScalableVideoView;

import org.json.JSONObject;
import org.parceler.Parcels;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import cz.msebera.android.httpclient.Header;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

//Array Adapter to populate recyclerView
public class TweetsArrayAdapter extends RecyclerView.Adapter<TweetsArrayAdapter.ViewHolder> {

    private ArrayList<Tweet> tweets;
    private static Context mContext;

    public TweetsArrayAdapter(Context context, ArrayList<Tweet> results) {
        this.mContext = context;
        this.tweets = results;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.content_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.binding.setHandlers(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Tweet tweet = tweets.get(position);
        User user = tweet.getUser();

        holder.binding.setTweet(tweet);
        holder.binding.setUser(user);

        // holder.binding.itemProfile.setTag(user);
        holder.binding.executePendingBindings();
        new PatternEditableBuilder().
                addPattern(Pattern.compile("\\@(\\w+)"), Color.BLUE,
                        new PatternEditableBuilder.SpannableClickedListener() {
                            @Override
                            public void onSpanClicked(String text) {
                                Log.v("ddd", text);
                                Intent i = new Intent(mContext, ProfileActivity.class);
                                i.putExtra("isUser", false);
                                i.putExtra("isUnknownUser", true);
                                i.putExtra("screenName", text);
                                mContext.startActivity(i);
                            }
                        }).
                addPattern(Pattern.compile("\\#(\\w+)"), Color.BLUE,
                        new PatternEditableBuilder.SpannableClickedListener() {
                            @Override
                            public void onSpanClicked(String text) {
                                Intent intent = new Intent(mContext, SearchActivity.class);
                                intent.putExtra("query", text);
                                mContext.startActivity(intent);
                            }
                        }).into(holder.binding.itemBody);


    }


    @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        //    Picasso.with(imageView.getContext()).load(url).placeholder(R.color.colorPrimary).
        //      // into(imageView);

        Glide.with(imageView.getContext()).load(url).bitmapTransform(new RoundedCornersTransformation(imageView.getContext(), 8, 0)).
                into(imageView);

    }

    @BindingAdapter("bind:timeCalc")
    public static void timeCalc(TextView textView, String createdAt) {
        String relativeDate = Utility.relativeTime(createdAt);
        textView.setText(relativeDate);
    }

    @BindingAdapter("bind:videoDisplay")
    public static void videoDisplay(ScalableVideoView view, String url) {
        if (url != null) {
            Uri uri = Uri.parse(url);
            try {
                view.setDataSource(view.getContext(), uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            view.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ContentItemBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            new PatternEditableBuilder().
                    addPattern(Pattern.compile("\\@(\\w+)"), Color.BLUE,
                            new PatternEditableBuilder.SpannableClickedListener() {
                                @Override
                                public void onSpanClicked(String text) {

                                }
                            }).into(binding.itemBody);

            binding.itemProfile.setOnClickListener(this);
            binding.itemRetweet.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            switch (view.getId()) {
                case R.id.item_profile:
                    onClickImage(position);
                    break;
                case R.id.item_reply:
                    onClickReply(position);
                    break;
                case R.id.item_retweet:
                    onClickRetweet(position);
                    break;
            }

        }

        public void onClickImage(int pos) {
            Intent i = new Intent(mContext, ProfileActivity.class);
            User user = (User) tweets.get(pos).getUser();
            i.putExtra("user", Parcels.wrap(user));
            i.putExtra("isUser", false);
            i.putExtra("isUnknownUser", false);
            mContext.startActivity(i);

        }

        public void onClickReply(int pos) {
            FragmentManager fm = ((AppCompatActivity) mContext).getSupportFragmentManager();
            Tweet t = tweets.get(pos);
            Bundle args = new Bundle();
            args.putBoolean("reply", true);
            args.putString("userId", t.getUser().getScreenName());
            args.putLong("tweetid", t.getTweetId());
            ComposeDialog dialog = ComposeDialog.newInstance(args);
            dialog.show(fm, "Dialog");
        }

        public void onClickRetweet(int pos) {
            Log.v("onretweet", "dsfsf");
            TwitterClient twitterClient = TwitterApplication.getRestClient();
            Tweet t = tweets.get(pos);
            RequestParams params = new RequestParams();
            params.put("id", t.getTweetId());
            twitterClient.retweet(new JsonHttpResponseHandler() {

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    super.onSuccess(statusCode, headers, response);
                    Log.v("onSuccessRetweet", "dsf");

                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                    Log.v("failure", errorResponse.toString());
                }


            }, params);
        }

    }
}
