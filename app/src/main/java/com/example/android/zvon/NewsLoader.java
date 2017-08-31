package com.example.android.zvon;

import android.content.Context;
import android.content.AsyncTaskLoader;

import java.util.List;

/**
 * Loads a list of news by using an Loader to perform the
 * network request to the given URL.
 */

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    //Tag for log messages
    private static final String LOG_TAG = NewsLoader.class.getName();

    //Query URL
    private String mUrl;

    /**
     * Constructs a new {@link NewsLoader}.
     *
     * @param context of the activity
     * @param url     to load data from
     */
    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    //Important: Notice that we also override the onStartLoading() method to call forceLoad()
    //which is a required step to actually trigger the loadInBackground() method to execute.
    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    //This is on a background thread.
    @Override
    public List<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of news.
        List<News> news = QueryUtils.fetchNewsData(mUrl);
        return news;
    }

}


