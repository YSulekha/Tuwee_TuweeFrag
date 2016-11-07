package com.codepath.apps.tweet.databinding;
import com.codepath.apps.tweet.R;
import com.codepath.apps.tweet.BR;
import android.view.View;
public class DialogTweetBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.container, 2);
        sViewsWithIds.put(R.id.dialog_counter, 3);
        sViewsWithIds.put(R.id.dialog_status, 4);
    }
    // views
    public final android.widget.FrameLayout container;
    public final android.widget.Button dialogButton;
    public final android.support.design.widget.TextInputLayout dialogCounter;
    public final android.support.design.widget.TextInputEditText dialogStatus;
    private final android.widget.RelativeLayout mboundView0;
    // variables
    private com.codepath.apps.tweet.fragments.ComposeDialog mHandlers;
    // values
    // listeners
    private OnClickListenerImpl mAndroidViewViewOnCl;
    // Inverse Binding Event Handlers

    public DialogTweetBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds);
        this.container = (android.widget.FrameLayout) bindings[2];
        this.dialogButton = (android.widget.Button) bindings[1];
        this.dialogButton.setTag(null);
        this.dialogCounter = (android.support.design.widget.TextInputLayout) bindings[3];
        this.dialogStatus = (android.support.design.widget.TextInputEditText) bindings[4];
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
            case BR.handlers :
                setHandlers((com.codepath.apps.tweet.fragments.ComposeDialog) variable);
                return true;
        }
        return false;
    }

    public void setHandlers(com.codepath.apps.tweet.fragments.ComposeDialog handlers) {
        this.mHandlers = handlers;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.handlers);
        super.requestRebind();
    }
    public com.codepath.apps.tweet.fragments.ComposeDialog getHandlers() {
        return mHandlers;
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
        android.view.View.OnClickListener androidViewViewOnCli = null;
        com.codepath.apps.tweet.fragments.ComposeDialog handlers = mHandlers;

        if ((dirtyFlags & 0x3L) != 0) {



                if (handlers != null) {
                    // read handlers::onClick
                    androidViewViewOnCli = (((mAndroidViewViewOnCl == null) ? (mAndroidViewViewOnCl = new OnClickListenerImpl()) : mAndroidViewViewOnCl).setValue(handlers));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.dialogButton.setOnClickListener(androidViewViewOnCli);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.codepath.apps.tweet.fragments.ComposeDialog value;
        public OnClickListenerImpl setValue(com.codepath.apps.tweet.fragments.ComposeDialog value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onClick(arg0);
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static DialogTweetBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static DialogTweetBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<DialogTweetBinding>inflate(inflater, com.codepath.apps.tweet.R.layout.dialog_tweet, root, attachToRoot, bindingComponent);
    }
    public static DialogTweetBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static DialogTweetBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.codepath.apps.tweet.R.layout.dialog_tweet, null, false), bindingComponent);
    }
    public static DialogTweetBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static DialogTweetBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/dialog_tweet_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new DialogTweetBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): handlers
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}