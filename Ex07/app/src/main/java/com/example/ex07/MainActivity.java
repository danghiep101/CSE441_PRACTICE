package com.example.ex07;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.ChildActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonOpenChildActivity = findViewById(R.id.button_open_child_activity);
        buttonOpenChildActivity.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, ChildActivity.class);
            startActivity(intent);
        });
    }
}

