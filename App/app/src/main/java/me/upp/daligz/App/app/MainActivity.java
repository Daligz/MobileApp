package me.upp.daligz.App.app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import me.upp.daligz.App.app.animations.AnimatedBackground;
import me.upp.daligz.App.app.request.ImageRequest;

public class MainActivity extends AppCompatActivity {

    private static final String API_URL = "https://picsum.photos/200/300?random=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.runAnimations();
    }

    private void runAnimations() {
        new AnimatedBackground(this).run();
    }

    private void loadImage() {
        final String result = new ImageRequest().get("http://localhost:6969/images/20/tecnology");
    }
}