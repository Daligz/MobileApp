package me.upp.daligz.App.app.downloader;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

// Utility class
public class ImageDownloader {
    public static void download(final String url, final ImageView imageView) {
        Picasso
                .get()
                .load(url)
                .into(imageView);
    }
}
