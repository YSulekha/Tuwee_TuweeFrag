package com.codepath.apps.tweet.databinding;
import com.codepath.apps.tweet.R;
import com.codepath.apps.tweet.BR;
import android.view.View;
public class ActivityProfileBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.profile_user, 1);
        sViewsWithIds.put(R.id.profile_image, 2);
        sViewsWithIds.put(R.id.profile_name, 3);
        sViewsWithIds.put(R.id.profile_tagline, 4);
        sViewsWithIds.put(R.id.profile_linear, 5);
        sViewsWithIds.put(R.id.profile_following, 6);
        sViewsWithIds.put(R.id.profile_followers, 7);
        sViewsWithIds.put(R.id.profile_container, 8);
    }
    // views
    public final android.widget.RelativeLayout activityProfile;
    public final android.widget.FrameLayout profileContainer;
    public final android.widget.TextView profileFollowers;
    public final android.widget.TextView profileFollowing;
    public final android.widget.ImageView profileImage;
    public final android.widget.LinearLayout profileLinear;
    public final android.widget.TextView profileName;
    public final android.widget.TextView profileTagline;
    public final android.widget.RelativeLayout profileUser;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityProfileBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds);
        this.activityProfile = (android.widget.RelativeLayout) bindings[0];
        this.activityProfile.setTag(null);
        this.profileContainer = (android.widget.FrameLayout) bindings[8];
        this.profileFollowers = (android.widget.TextView) bindings[7];
        this.profileFollowing = (android.widget.TextView) bindings[6];
        this.profileImage = (android.widget.ImageView) bindings[2];
        this.profileLinear = (android.widget.LinearLayout) bindings[5];
        this.profileName = (android.widget.TextView) bindings[3];
        this.profileTagline = (android.widget.TextView) bindings[4];
        this.profileUser = (android.widget.RelativeLayout) bindings[1];
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

    public static ActivityProfileBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityProfileBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityProfileBinding>inflate(inflater, com.codepath.apps.tweet.R.layout.activity_profile, root, attachToRoot, bindingComponent);
    }
    public static ActivityProfileBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityProfileBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.codepath.apps.tweet.R.layout.activity_profile, null, false), bindingComponent);
    }
    public static ActivityProfileBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityProfileBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_profile_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityProfileBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}