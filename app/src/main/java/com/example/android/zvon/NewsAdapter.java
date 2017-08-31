package com.example.android.zvon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class NewsAdapter extends ArrayAdapter<News> {

    //Construct a new News adapter with param "context" and "news" which is the data source of the adapter
    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);

    }

    //Return a list item view that displays information about the news at the given position in the list of news
    @Override //override to control how views item list get created
    public View getView(int position, View convertView, ViewGroup parent) {
        //Check if there is an existing item view (called convertView) that we can reuse,
        //otherwise, if convertView is null, then inflate a new list item layout
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_itemdesign, parent, false);
        }

        //find the news at the given position in the list of news
        News currentNews = getItem(position);

        //Find the TextView with the view ID SectionName
        TextView section = (TextView) convertView.findViewById(R.id.SectionName);
        section.setText(currentNews.getSection());

        TextView niceDate = (TextView) convertView.findViewById(R.id.PublicationDate);
        niceDate.setText(formatDate(currentNews.getDate()));

        TextView title = (TextView) convertView.findViewById(R.id.WebTitle);
        title.setText(currentNews.getTitle());

        return convertView;
    }

    //source for method: https://discussions.udacity.com/t/display-the-date-in-the-news-app/227647/3
    private String formatDate(String initialDate) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss'Z'");
        Date dateObject = null;

        try {
            dateObject = simpleDateFormat.parse(initialDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
        String niceDate = simpleDateFormat.format(dateObject);

        return niceDate;
    }


}


