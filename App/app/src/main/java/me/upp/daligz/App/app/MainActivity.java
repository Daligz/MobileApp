package me.upp.daligz.App.app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import me.upp.daligz.App.app.animations.AnimatedBackground;
import me.upp.daligz.App.app.downloader.ImageDownloader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.runAnimations();
        ImageDownloader.download(
                "https://estaticos.muyinteresante.es/uploads/images/gallery/594a1ced5bafe85dfd3c9869/gato-romano-redes.jpg",
                findViewById(R.id.imageViewer)
        );
    }

    private void runAnimations() {
        new AnimatedBackground(this).run();
    }
}