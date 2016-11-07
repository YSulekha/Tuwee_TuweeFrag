package com.codepath.apps.tweet.models;

//Model class for User

import android.util.Log;

import com.codepath.apps.tweet.database.TwitterDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Table(database = TwitterDatabase.class)
@Parcel(analyze={User.class})
public class User extends BaseModel {

    @Column
    private String userName;
    @Column
    private String screenName;
    @PrimaryKey
    @Column
    private long userId;
    @Column
    private String imageUrl;

    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    @Column
    private String tagLine;

    public String getTagLine() {
        return tagLine;
    }

    public int getFollowing() {
        return following;
    }

    public int getFollowers() {
        return followers;
    }

    @Column
    private int following;
    @Column
    private int followers;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }



    public String getUserName() {
        return userName;
    }

    public String getScreenName() {
        return screenName;
    }

    public long getUserId() {
        return userId;
    }

    public String getImageUrl() {
        return imageUrl;
    }


    public static User fromJSONObject(JSONObject jsonObject){
        User user = new User();
        try {
            user.userName = jsonObject.getString("name");
            user.screenName = "@"+jsonObject.getString("screen_name");
            user.imageUrl = jsonObject.getString("profile_image_url");
            user.userId = jsonObject.getLong("id");
            user.tagLine = jsonObject.getString("description");
            Log.v("user",user.tagLine);
            user.followers = jsonObject.getInt("followers_count");
            user.following = jsonObject.getInt("friends_count");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return user;
    }
}
