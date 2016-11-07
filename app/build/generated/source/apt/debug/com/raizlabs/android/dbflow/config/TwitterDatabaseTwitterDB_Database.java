package com.raizlabs.android.dbflow.config;

import com.codepath.apps.tweet.database.TwitterDatabase;
import com.codepath.apps.tweet.models.Tweet;
import com.codepath.apps.tweet.models.Tweet_Adapter;
import com.codepath.apps.tweet.models.User;
import com.codepath.apps.tweet.models.User_Adapter;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;

/**
 * This is generated code. Please do not modify */
public final class TwitterDatabaseTwitterDB_Database extends DatabaseDefinition {
  public TwitterDatabaseTwitterDB_Database(DatabaseHolder holder) {
    holder.putDatabaseForTable(Tweet.class, this);
    holder.putDatabaseForTable(User.class, this);
    models.add(Tweet.class);
    modelTableNames.put("Tweet", Tweet.class);
    modelAdapters.put(Tweet.class, new Tweet_Adapter(holder, this));
    models.add(User.class);
    modelTableNames.put("User", User.class);
    modelAdapters.put(User.class, new User_Adapter(holder, this));
  }

  @Override
  public final Class getAssociatedDatabaseClassFile() {
    return TwitterDatabase.class;
  }

  @Override
  public final boolean isForeignKeysSupported() {
    return false;
  }

  @Override
  public final boolean isInMemory() {
    return false;
  }

  @Override
  public final boolean backupEnabled() {
    return false;
  }

  @Override
  public final boolean areConsistencyChecksEnabled() {
    return false;
  }

  @Override
  public final int getDatabaseVersion() {
    return 1;
  }

  @Override
  public final String getDatabaseName() {
    return "TwitterDB";
  }
}
