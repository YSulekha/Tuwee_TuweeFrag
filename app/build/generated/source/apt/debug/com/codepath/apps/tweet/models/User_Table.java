package com.codepath.apps.tweet.models;

import com.raizlabs.android.dbflow.runtime.BaseContentProvider.PropertyConverter;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.property.BaseProperty;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.IntProperty;
import com.raizlabs.android.dbflow.sql.language.property.LongProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import java.lang.IllegalArgumentException;
import java.lang.String;

/**
 * This is generated code. Please do not modify */
public final class User_Table {
  public static final PropertyConverter PROPERTY_CONVERTER = new PropertyConverter(){ 
  public IProperty fromName(String columnName) {
  return com.codepath.apps.tweet.models.User_Table.getProperty(columnName); 
  }
  };

  public static final Property<String> userName = new Property<String>(User.class, "userName");

  public static final Property<String> screenName = new Property<String>(User.class, "screenName");

  public static final LongProperty userId = new LongProperty(User.class, "userId");

  public static final Property<String> imageUrl = new Property<String>(User.class, "imageUrl");

  public static final Property<String> tagLine = new Property<String>(User.class, "tagLine");

  public static final IntProperty following = new IntProperty(User.class, "following");

  public static final IntProperty followers = new IntProperty(User.class, "followers");

  public static final IProperty[] getAllColumnProperties() {
    return new IProperty[]{userName,screenName,userId,imageUrl,tagLine,following,followers};
  }

  public static BaseProperty getProperty(String columnName) {
    columnName = QueryBuilder.quoteIfNeeded(columnName);
    switch (columnName)  {
      case "`userName`":  {
        return userName;
      }
      case "`screenName`":  {
        return screenName;
      }
      case "`userId`":  {
        return userId;
      }
      case "`imageUrl`":  {
        return imageUrl;
      }
      case "`tagLine`":  {
        return tagLine;
      }
      case "`following`":  {
        return following;
      }
      case "`followers`":  {
        return followers;
      }
      default:  {
        throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
      }
    }
  }
}
