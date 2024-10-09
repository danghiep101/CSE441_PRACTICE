package com.example.btth03.ui.showstudent;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.btth03.R;
import com.example.btth03.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding  =  ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupRecyclerView();
        observeViewModel();
        
    }

    private void setupRecyclerView() {
    }

    private void observeViewModel() {
        
        
    }
}