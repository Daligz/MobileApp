package me.upp.daligz.App.app.animations;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public abstract class Animation {

    private static final List<Animation> ANIMATIONS = new ArrayList<>();

    private final AppCompatActivity appCompatActivity;

    public Animation(final @NonNull AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
        ANIMATIONS.add(this);
    }

    public AppCompatActivity getAppCompatActivity() {
        return appCompatActivity;
    }

    public void run() { }

    public void stop() { }
}
