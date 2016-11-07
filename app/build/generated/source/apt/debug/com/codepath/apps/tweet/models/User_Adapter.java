package com.codepath.apps.tweet.models;

import android.content.ContentValues;
import android.database.Cursor;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.DatabaseHolder;
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

public final class User_Adapter extends ModelAdapter<User> {
  public User_Adapter(DatabaseHolder holder, DatabaseDefinition databaseDefinition) {
    super(databaseDefinition);
  }

  @Override
  public final Class<User> getModelClass() {
    return User.class;
  }

  public final String getTableName() {
    return "`User`";
  }

  @Override
  public final IProperty[] getAllColumnProperties() {
    return User_Table.getAllColumnProperties();
  }

  @Override
  public final void bindToInsertValues(ContentValues values, User model) {
    if (model.getUserName() != null) {
      values.put(User_Table.userName.getCursorKey(), model.getUserName());
    } else {
      values.putNull(User_Table.userName.getCursorKey());
    }
    if (model.getScreenName() != null) {
      values.put(User_Table.screenName.getCursorKey(), model.getScreenName());
    } else {
      values.putNull(User_Table.screenName.getCursorKey());
    }
    values.put(User_Table.userId.getCursorKey(), model.getUserId());
    if (model.getImageUrl() != null) {
      values.put(User_Table.imageUrl.getCursorKey(), model.getImageUrl());
    } else {
      values.putNull(User_Table.imageUrl.getCursorKey());
    }
    if (model.getTagLine() != null) {
      values.put(User_Table.tagLine.getCursorKey(), model.getTagLine());
    } else {
      values.putNull(User_Table.tagLine.getCursorKey());
    }
    values.put(User_Table.following.getCursorKey(), model.getFollowing());
    values.put(User_Table.followers.getCursorKey(), model.getFollowers());
  }

  @Override
  public final void bindToContentValues(ContentValues values, User model) {
    bindToInsertValues(values, model);
  }

  @Override
  public final void bindToInsertStatement(DatabaseStatement statement, User model, int start) {
    if (model.getUserName() != null) {
      statement.bindString(1 + start, model.getUserName());
    } else {
      statement.bindNull(1 + start);
    }
    if (model.getScreenName() != null) {
      statement.bindString(2 + start, model.getScreenName());
    } else {
      statement.bindNull(2 + start);
    }
    statement.bindLong(3 + start, model.getUserId());
    if (model.getImageUrl() != null) {
      statement.bindString(4 + start, model.getImageUrl());
    } else {
      statement.bindNull(4 + start);
    }
    if (model.getTagLine() != null) {
      statement.bindString(5 + start, model.getTagLine());
    } else {
      statement.bindNull(5 + start);
    }
    statement.bindLong(6 + start, model.getFollowing());
    statement.bindLong(7 + start, model.getFollowers());
  }

  @Override
  public final void bindToStatement(DatabaseStatement statement, User model) {
    bindToInsertStatement(statement, model, 0);
  }

  @Override
  public final String getInsertStatementQuery() {
    return "INSERT INTO `User`(`userName`,`screenName`,`userId`,`imageUrl`,`tagLine`,`following`,`followers`) VALUES (?,?,?,?,?,?,?)";
  }

  @Override
  public final String getCompiledStatementQuery() {
    return "INSERT INTO `User`(`userName`,`screenName`,`userId`,`imageUrl`,`tagLine`,`following`,`followers`) VALUES (?,?,?,?,?,?,?)";
  }

  @Override
  public final String getCreationQuery() {
    return "CREATE TABLE IF NOT EXISTS `User`(`userName` TEXT,`screenName` TEXT,`userId` INTEGER,`imageUrl` TEXT,`tagLine` TEXT,`following` INTEGER,`followers` INTEGER, PRIMARY KEY(`userId`)" + ");";
  }

  @Override
  public final void loadFromCursor(Cursor cursor, User model) {
    int indexuserName = cursor.getColumnIndex("userName");
    if (indexuserName != -1 && !cursor.isNull(indexuserName)) {
      model.setUserName(cursor.getString(indexuserName));
    } else {
      model.setUserName(null);
    }
    int indexscreenName = cursor.getColumnIndex("screenName");
    if (indexscreenName != -1 && !cursor.isNull(indexscreenName)) {
      model.setScreenName(cursor.getString(indexscreenName));
    } else {
      model.setScreenName(null);
    }
    int indexuserId = cursor.getColumnIndex("userId");
    if (indexuserId != -1 && !cursor.isNull(indexuserId)) {
      model.setUserId(cursor.getLong(indexuserId));
    } else {
      model.setUserId(0);
    }
    int indeximageUrl = cursor.getColumnIndex("imageUrl");
    if (indeximageUrl != -1 && !cursor.isNull(indeximageUrl)) {
      model.setImageUrl(cursor.getString(indeximageUrl));
    } else {
      model.setImageUrl(null);
    }
    int indextagLine = cursor.getColumnIndex("tagLine");
    if (indextagLine != -1 && !cursor.isNull(indextagLine)) {
      model.setTagLine(cursor.getString(indextagLine));
    } else {
      model.setTagLine(null);
    }
    int indexfollowing = cursor.getColumnIndex("following");
    if (indexfollowing != -1 && !cursor.isNull(indexfollowing)) {
      model.setFollowing(cursor.getInt(indexfollowing));
    } else {
      model.setFollowing(0);
    }
    int indexfollowers = cursor.getColumnIndex("followers");
    if (indexfollowers != -1 && !cursor.isNull(indexfollowers)) {
      model.setFollowers(cursor.getInt(indexfollowers));
    } else {
      model.setFollowers(0);
    }
  }

  @Override
  public final boolean exists(User model, DatabaseWrapper wrapper) {
    return new Select(Method.count()).from(User.class).where(getPrimaryConditionClause(model)).count(wrapper) > 0;
  }

  @Override
  public final ConditionGroup getPrimaryConditionClause(User model) {
    ConditionGroup clause = ConditionGroup.clause();
    clause.and(User_Table.userId.eq(model.getUserId()));return clause;
  }

  @Override
  public final User newInstance() {
    return new User();
  }

  @Override
  public final BaseProperty getProperty(String name) {
    return User_Table.getProperty(name);
  }
}
