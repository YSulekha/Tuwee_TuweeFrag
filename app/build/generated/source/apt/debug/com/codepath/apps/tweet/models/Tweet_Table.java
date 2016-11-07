package com.codepath.apps.tweet.models;

import com.raizlabs.android.dbflow.runtime.BaseContentProvider.PropertyConverter;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.property.BaseProperty;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.LongProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import java.lang.Boolean;
import java.lang.IllegalArgumentException;
import java.lang.String;

/**
 * This is generated code. Please do not modify */
public final class Tweet_Table {
  public static final PropertyConverter PROPERTY_CONVERTER = new PropertyConverter(){ 
  public IProperty fromName(String columnName) {
  return com.codepath.apps.tweet.models.Tweet_Table.getProperty(columnName); 
  }
  };

  public static final LongProperty tweetId = new LongProperty(Tweet.class, "tweetId");

  public static final Property<String> createdAt = new Property<String>(Tweet.class, "createdAt");

  public static final LongProperty user_userId = new LongProperty(Tweet.class, "user_userId");

  public static final Property<String> body = new Property<String>(Tweet.class, "body");

  public static final Property<String> favoritedCount = new Property<String>(Tweet.class, "favoritedCount");

  public static final Property<String> retweetCount = new Property<String>(Tweet.class, "retweetCount");

  public static final Property<Boolean> isFavorited = new Property<Boolean>(Tweet.class, "isFavorited");

  public static final Property<String> mediaUrl = new Property<String>(Tweet.class, "mediaUrl");

  public static final IProperty[] getAllColumnProperties() {
    return new IProperty[]{tweetId,createdAt,user_userId,body,favoritedCount,retweetCount,isFavorited,mediaUrl};
  }

  public static BaseProperty getProperty(String columnName) {
    columnName = QueryBuilder.quoteIfNeeded(columnName);
    switch (columnName)  {
      case "`tweetId`":  {
        return tweetId;
      }
      case "`createdAt`":  {
        return createdAt;
      }
      case "`user_userId`":  {
        return user_userId;
      }
      case "`body`":  {
        return body;
      }
      case "`favoritedCount`":  {
        return favoritedCount;
      }
      case "`retweetCount`":  {
        return retweetCount;
      }
      case "`isFavorited`":  {
        return isFavorited;
      }
      case "`mediaUrl`":  {
        return mediaUrl;
      }
      default:  {
        throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
      }
    }
  }
}
