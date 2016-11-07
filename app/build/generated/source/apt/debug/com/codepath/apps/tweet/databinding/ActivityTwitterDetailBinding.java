package com.codepath.apps.tweet.databinding;
import com.codepath.apps.tweet.R;
import com.codepath.apps.tweet.BR;
import android.view.View;
public class ActivityTwitterDetailBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.detail_profile, 1);
        sViewsWithIds.put(R.id.detail_name, 2);
        sViewsWithIds.put(R.id.detail_screenname, 3);
        sViewsWithIds.put(R.id.detail_body, 4);
        sViewsWithIds.put(R.id.detail_media, 5);
        sViewsWithIds.put(R.id.detail_time, 6);
        sViewsWithIds.put(R.id.detail_favorite, 7);
        sViewsWithIds.put(R.id.detail_favorite_text, 8);
        sViewsWithIds.put(R.id.detail_retweet, 9);
        sViewsWithIds.put(R.id.detail_retweet_text, 10);
        sViewsWithIds.put(R.id.detail_reply, 11);
    }
    // views
    public final android.widget.RelativeLayout activityTwitterDetail;
    public final android.widget.TextView detailBody;
    public final android.widget.ImageView detailFavorite;
    public final android.widget.TextView detailFavoriteText;
    public final android.widget.ImageView detailMedia;
    public final android.widget.TextView detailName;
    public final android.widget.ImageView detailProfile;
    public final android.widget.ImageView detailReply;
    public final android.widget.ImageView detailRetweet;
    public final android.widget.TextView detailRetweetText;
    public final android.widget.TextView detailScreenname;
    public final android.widget.TextView detailTime;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityTwitterDetailBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds);
        this.activityTwitterDetail = (android.widget.RelativeLayout) bindings[0];
        this.activityTwitterDetail.setTag(null);
        this.detailBody = (android.widget.TextView) bindings[4];
        this.detailFavorite = (android.widget.ImageView) bindings[7];
        this.detailFavoriteText = (android.widget.TextView) bindings[8];
        this.detailMedia = (android.widget.ImageView) bindings[5];
        this.detailName = (android.widget.TextView) bindings[2];
        this.detailProfile = (android.widget.ImageView) bindings[1];
        this.detailReply = (android.widget.ImageView) bindings[11];
        this.detailRetweet = (android.widget.ImageView) bindings[9];
        this.detailRetweetText = (android.widget.TextView) bindings[10];
        this.detailScreenname = (android.widget.TextView) bindings[3];
        this.detailTime = (android.widget.TextView) bindings[6];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
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
        }
        return false;
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
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static ActivityTwitterDetailBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityTwitterDetailBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityTwitterDetailBinding>inflate(inflater, com.codepath.apps.tweet.R.layout.activity_twitter_detail, root, attachToRoot, bindingComponent);
    }
    public static ActivityTwitterDetailBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityTwitterDetailBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.codepath.apps.tweet.R.layout.activity_twitter_detail, null, false), bindingComponent);
    }
    public static ActivityTwitterDetailBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityTwitterDetailBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_twitter_detail_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityTwitterDetailBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}