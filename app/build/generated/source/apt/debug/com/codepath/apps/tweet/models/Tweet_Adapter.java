package com.codepath.apps.tweet.models;

import android.content.ContentValues;
import android.database.Cursor;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.DatabaseHolder;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.ConditionGroup;
import com.raizlabs.android.dbflow.sql.language.Method;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.sql.language.property.BaseProperty;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;

public final class Tweet_Adapter extends ModelAdapter<Tweet> {
  public Tweet_Adapter(DatabaseHolder holder, DatabaseDefinition databaseDefinition) {
    super(databaseDefinition);
  }

  @Override
  public final Class<Tweet> getModelClass() {
    return Tweet.class;
  }

  public final String getTableName() {
    return "`Tweet`";
  }

  @Override
  public final IProperty[] getAllColumnProperties() {
    return Tweet_Table.getAllColumnProperties();
  }

  @Override
  public final void bindToInsertValues(ContentValues values, Tweet model) {
    values.put(Tweet_Table.tweetId.getCursorKey(), model.getTweetId());
    if (model.getCreatedAt() != null) {
      values.put(Tweet_Table.createdAt.getCursorKey(), model.getCreatedAt());
    } else {
      values.putNull(Tweet_Table.createdAt.getCursorKey());
    }
    if (model.getUser() != null) {
      model.getUser().save();
      values.put(Tweet_Table.user_userId.getCursorKey(), model.getUser().getUserId());
    } else {
      values.putNull("`user_userId`");
    }
    if (model.getBody() != null) {
      values.put(Tweet_Table.body.getCursorKey(), model.getBody());
    } else {
      values.putNull(Tweet_Table.body.getCursorKey());
    }
    if (model.getFavoritedCount() != null) {
      values.put(Tweet_Table.favoritedCount.getCursorKey(), model.getFavoritedCount());
    } else {
      values.putNull(Tweet_Table.favoritedCount.getCursorKey());
    }
    if (model.getRetweetCount() != null) {
      values.put(Tweet_Table.retweetCount.getCursorKey(), model.getRetweetCount());
    } else {
      values.putNull(Tweet_Table.retweetCount.getCursorKey());
    }
    values.put(Tweet_Table.isFavorited.getCursorKey(), model.isFavorited() ? 1 : 0);
    if (model.getMediaUrl() != null) {
      values.put(Tweet_Table.mediaUrl.getCursorKey(), model.getMediaUrl());
    } else {
      values.putNull(Tweet_Table.mediaUrl.getCursorKey());
    }
  }

  @Override
  public final void bindToContentValues(ContentValues values, Tweet model) {
    bindToInsertValues(values, model);
  }

  @Override
  public final void bindToInsertStatement(DatabaseStatement statement, Tweet model, int start) {
    statement.bindLong(1 + start, model.getTweetId());
    if (model.getCreatedAt() != null) {
      statement.bindString(2 + start, model.getCreatedAt());
    } else {
      statement.bindNull(2 + start);
    }
    if (model.getUser() != null) {
      model.getUser().save();
      statement.bindLong(3 + start, model.getUser().getUserId());
    } else {
      statement.bindNull(3 + start);
    }
    if (model.getBody() != null) {
      statement.bindString(4 + start, model.getBody());
    } else {
      statement.bindNull(4 + start);
    }
    if (model.getFavoritedCount() != null) {
      statement.bindString(5 + start, model.getFavoritedCount());
    } else {
      statement.bindNull(5 + start);
    }
    if (model.getRetweetCount() != null) {
      statement.bindString(6 + start, model.getRetweetCount());
    } else {
      statement.bindNull(6 + start);
    }
    statement.bindLong(7 + start, model.isFavorited() ? 1 : 0);
    if (model.getMediaUrl() != null) {
      statement.bindString(8 + start, model.getMediaUrl());
    } else {
      statement.bindNull(8 + start);
    }
  }

  @Override
  public final void bindToStatement(DatabaseStatement statement, Tweet model) {
    bindToInsertStatement(statement, model, 0);
  }

  @Override
  public final String getInsertStatementQuery() {
    return "INSERT INTO `Tweet`(`tweetId`,`createdAt`,`user_userId`,`body`,`favoritedCount`,`retweetCount`,`isFavorited`,`mediaUrl`) VALUES (?,?,?,?,?,?,?,?)";
  }

  @Override
  public final String getCompiledStatementQuery() {
    return "INSERT INTO `Tweet`(`tweetId`,`createdAt`,`user_userId`,`body`,`favoritedCount`,`retweetCount`,`isFavorited`,`mediaUrl`) VALUES (?,?,?,?,?,?,?,?)";
  }

  @Override
  public final String getCreationQuery() {
    return "CREATE TABLE IF NOT EXISTS `Tweet`(`tweetId` INTEGER,`createdAt` TEXT,`user_userId` INTEGER,`body` TEXT,`favoritedCount` TEXT,`retweetCount` TEXT,`isFavorited` INTEGER,`mediaUrl` TEXT, PRIMARY KEY(`tweetId`)"+ ", FOREIGN KEY(`user_userId`) REFERENCES " + FlowManager.getTableName(User.class) + "(`userId`) ON UPDATE NO ACTION ON DELETE NO ACTION" + ");";
  }

  @Override
  public final void loadFromCursor(Cursor cursor, Tweet model) {
    int indextweetId = cursor.getColumnIndex("tweetId");
    if (indextweetId != -1 && !cursor.isNull(indextweetId)) {
      model.setTweetId(cursor.getLong(indextweetId));
    } else {
      model.setTweetId(0);
    }
    int indexcreatedAt = cursor.getColumnIndex("createdAt");
    if (indexcreatedAt != -1 && !cursor.isNull(indexcreatedAt)) {
      model.setCreatedAt(cursor.getString(indexcreatedAt));
    } else {
      model.setCreatedAt(null);
    }
    //// Only load model if references match, for efficiency
    int indexuser_userId = cursor.getColumnIndex("user_userId");
    if (indexuser_userId != -1 && !cursor.isNull(indexuser_userId)) {
      model.setUser(new com.raizlabs.android.dbflow.sql.language.Select().from(com.codepath.apps.tweet.models.User.class).where()
          .and(com.codepath.apps.tweet.models.User_Table.userId.eq(cursor.getLong(indexuser_userId))).querySingle());
    }
    int indexbody = cursor.getColumnIndex("body");
    if (indexbody != -1 && !cursor.isNull(indexbody)) {
      model.setBody(cursor.getString(indexbody));
    } else {
      model.setBody(null);
    }
    int indexfavoritedCount = cursor.getColumnIndex("favoritedCount");
    if (indexfavoritedCount != -1 && !cursor.isNull(indexfavoritedCount)) {
      model.setFavoritedCount(cursor.getString(indexfavoritedCount));
    } else {
      model.setFavoritedCount(null);
    }
    int indexretweetCount = cursor.getColumnIndex("retweetCount");
    if (indexretweetCount != -1 && !cursor.isNull(indexretweetCount)) {
      model.setRetweetCount(cursor.getString(indexretweetCount));
    } else {
      model.setRetweetCount(null);
    }
    int indexisFavorited = cursor.getColumnIndex("isFavorited");
    if (indexisFavorited != -1 && !cursor.isNull(indexisFavorited)) {
      model.setFavorited(cursor.getInt(indexisFavorited) == 1 ? true : false);
    } else {
      model.setFavorited(false);
    }
    int indexmediaUrl = cursor.getColumnIndex("mediaUrl");
    if (indexmediaUrl != -1 && !cursor.isNull(indexmediaUrl)) {
      model.setMediaUrl(cursor.getString(indexmediaUrl));
    } else {
      model.setMediaUrl(null);
    }
  }

  @Override
  public final boolean exists(Tweet model, DatabaseWrapper wrapper) {
    return new Select(Method.count()).from(Tweet.class).where(getPrimaryConditionClause(model)).count(wrapper) > 0;
  }

  @Override
  public final ConditionGroup getPrimaryConditionClause(Tweet model) {
    ConditionGroup clause = ConditionGroup.clause();
    clause.and(Tweet_Table.tweetId.eq(model.getTweetId()));return clause;
  }

  @Override
  public final Tweet newInstance() {
    return new Tweet();
  }

  @Override
  public final BaseProperty getProperty(String name) {
    return Tweet_Table.getProperty(name);
  }
}
