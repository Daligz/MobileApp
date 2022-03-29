package me.upp.daligz.App.app;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import me.upp.daligz.App.app.animations.AnimatedBackground;
import me.upp.daligz.App.app.downloader.ImageDownloader;

public class MainActivity extends AppCompatActivity {

    private static final String API_URL = "https://picsum.photos/200/300?random=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.runAnimations();
        ImageDownloader.download(
                API_URL,
                findViewById(R.id.imageViewer)
        );
        final Button button = (Button) findViewById(R.id.buttonLoad);
        button.setOnClickListener(view -> ImageDownloader.download(API_URL, this));
    }

    private void runAnimations() {
        new AnimatedBackground(this).run();
    }
}