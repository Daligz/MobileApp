package me.upp.daligz.App.app.downloader;

import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import me.upp.daligz.App.app.R;

// Utility class
public class ImageDownloader {

    public static void download(final String url, final ImageView imageView) {
        Picasso
                .get()
                .load(url)
                .into(imageView);
    }

    public static void download(final String url, final AppCompatActivity appCompatActivity) {
        final ImageView imageView = new ImageView(appCompatActivity);
        final LinearLayout linearLayout = (LinearLayout) appCompatActivity.findViewById(R.id.linear_layout);
        linearLayout.addView(imageView);
        ImageDownloader.download(url, imageView);
    }
}
