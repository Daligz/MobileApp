package me.upp.daligz.App.app.animations;

import android.graphics.drawable.AnimationDrawable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import me.upp.daligz.App.app.R;

public class AnimatedBackground extends Animation {

    public AnimatedBackground(final @NonNull AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
    }

    @Override
    public void run() {
        final ConstraintLayout constraintLayout = this.getAppCompatActivity().findViewById(R.id.layout);
        final AnimationDrawable animatedBackground = (AnimationDrawable) constraintLayout.getBackground();
        animatedBackground.setEnterFadeDuration(2000);
        animatedBackground.setExitFadeDuration(4000);
        animatedBackground.start();
    }
}
