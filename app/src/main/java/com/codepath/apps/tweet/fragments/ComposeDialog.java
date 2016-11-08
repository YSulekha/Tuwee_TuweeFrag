package com.codepath.apps.tweet.fragments;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepath.apps.tweet.R;
import com.codepath.apps.tweet.databinding.DialogTweetBinding;
import com.loopj.android.http.RequestParams;


public class ComposeDialog extends DialogFragment {

    private DialogTweetBinding binding;
    String status;
   private SaveFilterListener listener;
   private static boolean isReply=false;
    private static String userId;
    private static  long tweetId;
    private static HomeTimeLineFragment fragment;
    public ComposeDialog(){

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity){
           this.listener = (SaveFilterListener) context;
        }
    }

    public interface SaveFilterListener{
       // void onTweet(String status,boolean isReply);
        void onTweet(RequestParams params);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static ComposeDialog newInstance(Bundle args){
        ComposeDialog cd = new ComposeDialog();
     //  fragment = (HomeTimeLineFragment) args.get("fragment");
      if(args != null){
            isReply = args.getBoolean("reply");
            userId = args.getString("userId");
            tweetId = args.getLong("tweetId");
        }
        return cd;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       //return inflater.inflate(R.layout.dialog_tweet,container);
       binding =  DataBindingUtil.inflate(inflater,R.layout.dialog_tweet,container,false);

        binding.setHandlers(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(isReply){
            binding.dialogStatus.setText(userId);
        }
        status = binding.dialogStatus.getText().toString();

    }

 /*   public void onClick(View v){
        if(isReply){
            listener = (TwitterDetailActivity) getActivity();
            RequestParams params = new RequestParams();
            status = binding.dialogStatus.getText().toString();
            params.put("status",status);
            params.put("in_reply_to_status_id",tweetId);
            listener.onTweet(params);

        }
        else {
            listener = (TimelineActivity) getActivity();

            status = binding.dialogStatus.getText().toString();
            RequestParams params = new RequestParams();
            params.put("status", status);
            if (isReply) {
                params.put("in_reply_to_status_id", tweetId);
            }
            listener.onTweet(params);
        }
       // listener.onTweet(status,false);
        dismiss();
    }*/
    public void onClick(View v){
        status = binding.dialogStatus.getText().toString();
        RequestParams params = new RequestParams();
        params.put("status", status);
        if(tweetId!=0){
            params.put("in_reply_to_status_id", tweetId);
        }
      //  TweetsListFragment fragment = new TweetsListFragment();
        //   fragment.twitterClient =
     //   fragment.onTweet(params);
        listener.onTweet(params);
        dismiss();
    }
}
