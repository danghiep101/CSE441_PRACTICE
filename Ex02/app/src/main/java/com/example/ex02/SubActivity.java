package com.example.ex02;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sub);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Sub ACtivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Sub ACtivity", "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Sub ACtivity", "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Sub ACtivity", "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Sub ACtivity", "onDestroy");

    }
}