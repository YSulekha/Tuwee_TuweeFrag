
package android.databinding;
import com.codepath.apps.tweet.BR;
class DataBinderMapper {
    final static int TARGET_MIN_SDK = 16;
    public DataBinderMapper() {
    }
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case com.codepath.apps.tweet.R.layout.activity_timeline:
                    return com.codepath.apps.tweet.databinding.ActivityTimelineBinding.bind(view, bindingComponent);
                case com.codepath.apps.tweet.R.layout.activity_search:
                    return com.codepath.apps.tweet.databinding.ActivitySearchBinding.bind(view, bindingComponent);
                case com.codepath.apps.tweet.R.layout.activity_profile:
                    return com.codepath.apps.tweet.databinding.ActivityProfileBinding.bind(view, bindingComponent);
                case com.codepath.apps.tweet.R.layout.content_timeline:
                    return com.codepath.apps.tweet.databinding.ContentTimelineBinding.bind(view, bindingComponent);
                case com.codepath.apps.tweet.R.layout.ontent_backup:
                    return com.codepath.apps.tweet.databinding.OntentBackupBinding.bind(view, bindingComponent);
                case com.codepath.apps.tweet.R.layout.dialog_tweet:
                    return com.codepath.apps.tweet.databinding.DialogTweetBinding.bind(view, bindingComponent);
                case com.codepath.apps.tweet.R.layout.content_item:
                    return com.codepath.apps.tweet.databinding.ContentItemBinding.bind(view, bindingComponent);
                case com.codepath.apps.tweet.R.layout.activity_twitter_detail:
                    return com.codepath.apps.tweet.databinding.ActivityTwitterDetailBinding.bind(view, bindingComponent);
                case com.codepath.apps.tweet.R.layout.fragment_tweets_list:
                    return com.codepath.apps.tweet.databinding.FragmentTweetsListBinding.bind(view, bindingComponent);
        }
        return null;
    }
    android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case 1086858365: {
                if(tag.equals("layout/activity_timeline_0")) {
                    return com.codepath.apps.tweet.R.layout.activity_timeline;
                }
                break;
            }
            case 101625572: {
                if(tag.equals("layout/activity_search_0")) {
                    return com.codepath.apps.tweet.R.layout.activity_search;
                }
                break;
            }
            case 366786799: {
                if(tag.equals("layout/activity_profile_0")) {
                    return com.codepath.apps.tweet.R.layout.activity_profile;
                }
                break;
            }
            case 1905582653: {
                if(tag.equals("layout/content_timeline_0")) {
                    return com.codepath.apps.tweet.R.layout.content_timeline;
                }
                break;
            }
            case 1266377687: {
                if(tag.equals("layout/ontent_backup_0")) {
                    return com.codepath.apps.tweet.R.layout.ontent_backup;
                }
                break;
            }
            case -890969232: {
                if(tag.equals("layout/dialog_tweet_0")) {
                    return com.codepath.apps.tweet.R.layout.dialog_tweet;
                }
                break;
            }
            case 634001935: {
                if(tag.equals("layout/content_item_0")) {
                    return com.codepath.apps.tweet.R.layout.content_item;
                }
                break;
            }
            case 600717465: {
                if(tag.equals("layout/activity_twitter_detail_0")) {
                    return com.codepath.apps.tweet.R.layout.activity_twitter_detail;
                }
                break;
            }
            case 2117015650: {
                if(tag.equals("layout/fragment_tweets_list_0")) {
                    return com.codepath.apps.tweet.R.layout.fragment_tweets_list;
                }
                break;
            }
        }
        return 0;
    }
    String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"
            ,"handlers"
            ,"tweet"
            ,"user"};
    }
}