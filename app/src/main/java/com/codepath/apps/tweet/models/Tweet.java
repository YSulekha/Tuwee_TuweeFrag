package com.codepath.apps.tweet.models;

//Model class for Tweets

import android.util.Log;

import com.codepath.apps.tweet.database.TwitterDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;

@Table(database = TwitterDatabase.class)
@Parcel(analyze={Tweet.class})
public class Tweet extends BaseModel{

    @Column
    @PrimaryKey
    private long tweetId;
    @Column
    private String createdAt;
    @Column
    @ForeignKey(saveForeignKeyModel = true)
    private User user;

    @Column
    private String body;

    @Column
    private String favoritedCount;

    @Column
    private String retweetCount;

    public boolean isFavorited() {
        return isFavorited;
    }

    public void setFavorited(boolean favorited) {
        isFavorited = favorited;
    }

    @Column
    private boolean isFavorited;

    public String getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(String retweetCount) {
        this.retweetCount = retweetCount;
    }

    public String getFavoritedCount() {
        return favoritedCount;
    }

    public void setFavoritedCount(String favoritedCount) {
        this.favoritedCount = favoritedCount;
    }



    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    private String videoUrl;

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }
@Column
    private String mediaUrl;

    public void setTweetId(long tweetId) {
        this.tweetId = tweetId;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBody(String body) {
        this.body = body;
    }




    public long getTweetId() {
        return tweetId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public User getUser() {
        return user;
    }

    public String getBody() {
        return body;
    }




    public static Tweet fromJSONObject(JSONObject jsonObject){
        Tweet tweet = new Tweet();
        try {
            tweet.body = jsonObject.getString("text");
            tweet.createdAt = jsonObject.getString("created_at");
            tweet.retweetCount = String.valueOf(jsonObject.getInt("retweet_count"));
            tweet.favoritedCount = String.valueOf(jsonObject.getInt("favorite_count"));
            tweet.isFavorited = jsonObject.getBoolean("favorited");
            User user = User.fromJSONObject(jsonObject.getJSONObject("user"));
            user.save();
            tweet.user = user;
            tweet.tweetId = jsonObject.getLong("id");
            if(jsonObject.getJSONObject("entities").has("media")) {
                JSONArray mediaArray = jsonObject.getJSONObject("entities").getJSONArray("media");
                if (mediaArray.length() > 0) {
                    String type = mediaArray.getJSONObject(0).getString("type");
                    if (type.equals("photo")) {
                        tweet.mediaUrl = mediaArray.getJSONObject(0).getString("media_url") + ":large";
                    }
                }
            }
            //[video_info][variants][0][url]
            JSONArray videoArray = jsonObject.getJSONObject("extended_entities").getJSONArray("media");
            for(int i=0;i<videoArray.length();i++){
                JSONObject mediaObject = videoArray.getJSONObject(i);
                if(mediaObject.getString("type").equals("video")){
                    JSONArray videoVariants = mediaObject.getJSONObject("video_info").getJSONArray("variants");
                    if(videoVariants.length()>0) {
                        String url = videoVariants.getJSONObject(0).getString("url");
                        tweet.videoUrl = url;
                        Log.v("videoUrlTweet",tweet.videoUrl);
                        break;
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tweet;
    }

    public static ArrayList<Tweet> fromJSONArray(JSONArray result){
        ArrayList<Tweet> tweets = new ArrayList<>();
        for(int i=0;i < result.length();i++){
            JSONObject tweetObject = null;
            try {
                tweetObject = result.getJSONObject(i);
            } catch (JSONException e) {
                continue;
            }
            Tweet tweet = fromJSONObject(tweetObject);
            tweet.save();
            tweets.add(tweet);
        }
        return tweets;
    }

}

