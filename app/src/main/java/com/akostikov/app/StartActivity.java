package com.akostikov.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;

import com.akostikov.app.main_view.MainActivity;


public class StartActivity extends Activity {

    private final Handler handler = new Handler();
    private Runnable goNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        goNext = () -> startActivity(new Intent(this, MainActivity.class));
        handler.postDelayed(goNext, 2000);
    }

    @Override
    protected void onStop() {
        handler.removeCallbacks(goNext);
        super.onStop();
    }
}
