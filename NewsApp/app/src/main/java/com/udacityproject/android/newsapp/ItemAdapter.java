package com.udacityproject.android.newsapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<ItemInfo> {
    ItemAdapter(Context context, ArrayList<ItemInfo> newsItems) {
        super(context, 0, newsItems);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_view, parent, false);
        }
        ItemInfo newsItem = getItem(position);
        TextView sectionView = listItemView.findViewById(R.id.category);
        TextView titleView = listItemView.findViewById(R.id.title);
        TextView dateView = listItemView.findViewById(R.id.date);
        TextView authorView = listItemView.findViewById(R.id.author_name);
        ImageView imageView = listItemView.findViewById(R.id.image_news_id);

        sectionView.setText(newsItem != null ? newsItem.getSection() : null);
        titleView.setText(newsItem != null ? newsItem.getNewsTitle() : null);
        dateView.setText(newsItem != null ? newsItem.getDate() : null);
        authorView.setText(newsItem != null ? newsItem.getAuthorName() : null);

        imageView.setImageResource(R.mipmap.ic_launcher_guardians);

        return listItemView;
    }
}