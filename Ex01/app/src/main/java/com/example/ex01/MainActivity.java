package com.example.ex01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextA, editTextB, editTextResult;
    private Button btnCaculate, btnBack, btnSubtract, btnDevide, btnMuiply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int A = Integer.parseInt("0" + editTextA.getText().toString());
                int B = Integer.parseInt("0" + editTextB.getText().toString());
                int result = A - B;
                editTextResult.setText(String.valueOf(result));
            }
        });

        btnMuiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int A = Integer.parseInt("0" + editTextA.getText().toString());
                int B = Integer.parseInt("0" + editTextB.getText().toString());
                int result = A * B;
                editTextResult.setText(String.valueOf(result));
            }
        });

        btnDevide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int A = Integer.parseInt("0" + editTextA.getText().toString());
                int B = Integer.parseInt("0" + editTextB.getText().toString());
                if(B == 0){
                    editTextB.setError("B cannot be 0");
                }else {
                    int result = A / B;
                    editTextResult.setText(String.valueOf(result));
                }

            }
        });
    }

    private void initView() {
        editTextA =findViewById(R.id.edt_A);
        editTextB =findViewById(R.id.edt_B);
        editTextResult =findViewById(R.id.edt_result);
        btnCaculate = findViewById(R.id.btn_caculate);
        btnSubtract = findViewById(R.id.btn_subtract);
        btnDevide = findViewById(R.id.btn_devide);
        btnMuiply = findViewById(R.id.btn_mutiply);
    }


    public void onClick(View view) {

        int A = Integer.parseInt("0" + editTextA.getText().toString());
        int B = Integer.parseInt("0" + editTextB.getText().toString());
        int result = A + B;
        Log.d("Tag", String.valueOf(A));
        editTextResult.setText(String.valueOf(result));

        Intent getIntent = getIntent();
        String stringExtra = getIntent.getStringExtra("KEY_EXTRA");
        Toast.makeText(this, stringExtra, Toast.LENGTH_LONG).show();
    }
}