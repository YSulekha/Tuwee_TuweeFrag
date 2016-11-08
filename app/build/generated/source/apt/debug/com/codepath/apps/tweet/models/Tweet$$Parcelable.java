
package com.codepath.apps.tweet.models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.InjectionUtil;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

@Generated(value = "org.parceler.ParcelAnnotationProcessor", date = "2016-11-07T19:52-0800")
@SuppressWarnings({
    "unchecked",
    "deprecation"
})
public class Tweet$$Parcelable
    implements Parcelable, ParcelWrapper<com.codepath.apps.tweet.models.Tweet>
{

    private com.codepath.apps.tweet.models.Tweet tweet$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Tweet$$Parcelable.Creator$$0 CREATOR = new Tweet$$Parcelable.Creator$$0();

    public Tweet$$Parcelable(com.codepath.apps.tweet.models.Tweet tweet$$2) {
        tweet$$0 = tweet$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(tweet$$0, parcel$$0, flags, new HashSet<Integer>());
    }

    public static void write(com.codepath.apps.tweet.models.Tweet tweet$$1, android.os.Parcel parcel$$1, int flags$$0, Set<Integer> identitySet$$0) {
        int identity$$0 = System.identityHashCode(tweet$$1);
        parcel$$1 .writeInt(identity$$0);
        if (!identitySet$$0 .contains(identity$$0)) {
            identitySet$$0 .add(identity$$0);
            if (tweet$$1 == null) {
                parcel$$1 .writeInt(-1);
            } else {
                parcel$$1 .writeInt(1);
                parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.codepath.apps.tweet.models.Tweet.class, tweet$$1, "createdAt"));
                parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.codepath.apps.tweet.models.Tweet.class, tweet$$1, "videoUrl"));
                parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.codepath.apps.tweet.models.Tweet.class, tweet$$1, "mediaUrl"));
                parcel$$1 .writeInt((InjectionUtil.getField(boolean.class, com.codepath.apps.tweet.models.Tweet.class, tweet$$1, "isFavorited")? 1 : 0));
                parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.codepath.apps.tweet.models.Tweet.class, tweet$$1, "favoritedCount"));
                parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.codepath.apps.tweet.models.Tweet.class, tweet$$1, "body"));
                com.codepath.apps.tweet.models.User$$Parcelable.write(InjectionUtil.getField(com.codepath.apps.tweet.models.User.class, com.codepath.apps.tweet.models.Tweet.class, tweet$$1, "user"), parcel$$1, flags$$0, identitySet$$0);
                parcel$$1 .writeLong(InjectionUtil.getField(long.class, com.codepath.apps.tweet.models.Tweet.class, tweet$$1, "tweetId"));
                parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.codepath.apps.tweet.models.Tweet.class, tweet$$1, "retweetCount"));
            }
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.codepath.apps.tweet.models.Tweet getParcel() {
        return tweet$$0;
    }

    public static com.codepath.apps.tweet.models.Tweet read(android.os.Parcel parcel$$3, Map<Integer, Object> identityMap$$0) {
        com.codepath.apps.tweet.models.Tweet tweet$$3;
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$0 .containsKey(identity$$1)) {
            com.codepath.apps.tweet.models.Tweet tweet$$4 = ((com.codepath.apps.tweet.models.Tweet) identityMap$$0 .get(identity$$1));
            if ((tweet$$4 == null)&&(identity$$1 != 0)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return tweet$$4;
        }
        if (parcel$$3 .readInt() == -1) {
            tweet$$3 = null;
            identityMap$$0 .put(identity$$1, null);
        } else {
            com.codepath.apps.tweet.models.Tweet tweet$$5;
            identityMap$$0 .put(identity$$1, null);
            tweet$$5 = new com.codepath.apps.tweet.models.Tweet();
            identityMap$$0 .put(identity$$1, tweet$$5);
            InjectionUtil.setField(com.codepath.apps.tweet.models.Tweet.class, tweet$$5, "createdAt", parcel$$3 .readString());
            InjectionUtil.setField(com.codepath.apps.tweet.models.Tweet.class, tweet$$5, "videoUrl", parcel$$3 .readString());
            InjectionUtil.setField(com.codepath.apps.tweet.models.Tweet.class, tweet$$5, "mediaUrl", parcel$$3 .readString());
            InjectionUtil.setField(com.codepath.apps.tweet.models.Tweet.class, tweet$$5, "isFavorited", (parcel$$3 .readInt() == 1));
            InjectionUtil.setField(com.codepath.apps.tweet.models.Tweet.class, tweet$$5, "favoritedCount", parcel$$3 .readString());
            InjectionUtil.setField(com.codepath.apps.tweet.models.Tweet.class, tweet$$5, "body", parcel$$3 .readString());
            com.codepath.apps.tweet.models.User user$$0 = com.codepath.apps.tweet.models.User$$Parcelable.read(parcel$$3, identityMap$$0);
            InjectionUtil.setField(com.codepath.apps.tweet.models.Tweet.class, tweet$$5, "user", user$$0);
            InjectionUtil.setField(com.codepath.apps.tweet.models.Tweet.class, tweet$$5, "tweetId", parcel$$3 .readLong());
            InjectionUtil.setField(com.codepath.apps.tweet.models.Tweet.class, tweet$$5, "retweetCount", parcel$$3 .readString());
            tweet$$3 = tweet$$5;
        }
        return tweet$$3;
    }

    public final static class Creator$$0
        implements Creator<Tweet$$Parcelable>
    {


        @Override
        public Tweet$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new Tweet$$Parcelable(read(parcel$$2, new HashMap<Integer, Object>()));
        }

        @Override
        public Tweet$$Parcelable[] newArray(int size) {
            return new Tweet$$Parcelable[size] ;
        }

    }

}
