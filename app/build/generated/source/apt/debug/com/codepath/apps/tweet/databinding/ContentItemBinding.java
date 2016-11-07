package com.codepath.apps.tweet.databinding;
import com.codepath.apps.tweet.R;
import com.codepath.apps.tweet.BR;
import android.view.View;
public class ContentItemBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.item_favorite, 9);
        sViewsWithIds.put(R.id.item_retweet, 10);
        sViewsWithIds.put(R.id.item_reply, 11);
        sViewsWithIds.put(R.id.item_reply_text, 12);
    }
    // views
    public final com.codepath.apps.tweet.utils.LinkifiedTextView itemBody;
    public final android.widget.ImageView itemFavorite;
    public final android.widget.TextView itemFavoriteText;
    public final android.widget.TextView itemName;
    public final android.widget.ImageView itemProfile;
    public final android.widget.ImageView itemReply;
    public final android.widget.TextView itemReplyText;
    public final android.widget.ImageView itemRetweet;
    public final android.widget.TextView itemRetweetText;
    public final android.widget.TextView itemScreenname;
    public final android.widget.TextView itemTime;
    public final com.yqritc.scalablevideoview.ScalableVideoView itemVideoView;
    private final android.widget.RelativeLayout mboundView0;
    // variables
    private com.codepath.apps.tweet.models.Tweet mTweet;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ContentItemBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds);
        this.itemBody = (com.codepath.apps.tweet.utils.LinkifiedTextView) bindings[5];
        this.itemBody.setTag(null);
        this.itemFavorite = (android.widget.ImageView) bindings[9];
        this.itemFavoriteText = (android.widget.TextView) bindings[6];
        this.itemFavoriteText.setTag(null);
        this.itemName = (android.widget.TextView) bindings[2];
        this.itemName.setTag(null);
        this.itemProfile = (android.widget.ImageView) bindings[1];
        this.itemProfile.setTag(null);
        this.itemReply = (android.widget.ImageView) bindings[11];
        this.itemReplyText = (android.widget.TextView) bindings[12];
        this.itemRetweet = (android.widget.ImageView) bindings[10];
        this.itemRetweetText = (android.widget.TextView) bindings[7];
        this.itemRetweetText.setTag(null);
        this.itemScreenname = (android.widget.TextView) bindings[4];
        this.itemScreenname.setTag(null);
        this.itemTime = (android.widget.TextView) bindings[3];
        this.itemTime.setTag(null);
        this.itemVideoView = (com.yqritc.scalablevideoview.ScalableVideoView) bindings[8];
        this.itemVideoView.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean setVariable(int variableId, Object variable) {
        switch(variableId) {
            case BR.tweet :
                setTweet((com.codepath.apps.tweet.models.Tweet) variable);
                return true;
            case BR.user :
            case BR.handlers :
                return true;
        }
        return false;
    }

    public void setUser(com.codepath.apps.tweet.models.User user) {
        // not used, ignore
    }
    public com.codepath.apps.tweet.models.User getUser() {
        return null;
    }
    public void setHandlers(com.codepath.apps.tweet.adapters.TweetsArrayAdapter handlers) {
        // not used, ignore
    }
    public com.codepath.apps.tweet.adapters.TweetsArrayAdapter getHandlers() {
        return null;
    }
    public void setTweet(com.codepath.apps.tweet.models.Tweet tweet) {
        this.mTweet = tweet;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.tweet);
        super.requestRebind();
    }
    public com.codepath.apps.tweet.models.Tweet getTweet() {
        return mTweet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String bodyTweet = null;
        java.lang.String screenNameUserTweet = null;
        java.lang.String createdAtTweet = null;
        java.lang.String favoritedCountTweet = null;
        java.lang.String imageUrlUserTweet = null;
        java.lang.String videoUrlTweet = null;
        com.codepath.apps.tweet.models.Tweet tweet = mTweet;
        com.codepath.apps.tweet.models.User userTweet = null;
        java.lang.String userNameUserTweet = null;
        java.lang.String retweetCountTweet = null;

        if ((dirtyFlags & 0x9L) != 0) {



                if (tweet != null) {
                    // read tweet.body
                    bodyTweet = tweet.getBody();
                    // read tweet.createdAt
                    createdAtTweet = tweet.getCreatedAt();
                    // read tweet.favoritedCount
                    favoritedCountTweet = tweet.getFavoritedCount();
                    // read tweet.videoUrl
                    videoUrlTweet = tweet.getVideoUrl();
                    // read tweet.user
                    userTweet = tweet.getUser();
                    // read tweet.retweetCount
                    retweetCountTweet = tweet.getRetweetCount();
                }


                if (userTweet != null) {
                    // read tweet.user.screenName
                    screenNameUserTweet = userTweet.getScreenName();
                    // read tweet.user.imageUrl
                    imageUrlUserTweet = userTweet.getImageUrl();
                    // read tweet.user.userName
                    userNameUserTweet = userTweet.getUserName();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.itemBody, bodyTweet);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.itemFavoriteText, favoritedCountTweet);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.itemName, userNameUserTweet);
            com.codepath.apps.tweet.adapters.TweetsArrayAdapter.loadImage(this.itemProfile, imageUrlUserTweet);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.itemRetweetText, retweetCountTweet);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.itemScreenname, screenNameUserTweet);
            com.codepath.apps.tweet.adapters.TweetsArrayAdapter.timeCalc(this.itemTime, createdAtTweet);
            com.codepath.apps.tweet.adapters.TweetsArrayAdapter.videoDisplay(this.itemVideoView, videoUrlTweet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static ContentItemBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ContentItemBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ContentItemBinding>inflate(inflater, com.codepath.apps.tweet.R.layout.content_item, root, attachToRoot, bindingComponent);
    }
    public static ContentItemBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ContentItemBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.codepath.apps.tweet.R.layout.content_item, null, false), bindingComponent);
    }
    public static ContentItemBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ContentItemBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/content_item_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ContentItemBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): tweet
        flag 1 (0x2L): user
        flag 2 (0x3L): handlers
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}