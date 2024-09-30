package com.example.ex04;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    private EditText txtFar, txtCel;
    private Button btnCel, btnFar, btnClear, btnBmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFar = findViewById(R.id.txtFar);
        txtCel = findViewById(R.id.txtCel);
        btnCel = findViewById(R.id.btnCel);
        btnFar = findViewById(R.id.btnFar);
        btnClear = findViewById(R.id.btnClear);
        btnBmi =findViewById(R.id.btnBMI);

        btnCel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fahrenheitStr = txtFar.getText().toString();
                if (!fahrenheitStr.isEmpty()) {
                    double fahrenheit = Double.parseDouble(fahrenheitStr);
                    double celsius = (fahrenheit - 32) * 5 / 9;
                    txtCel.setText(String.valueOf(celsius));
                }
            }
        });

        btnFar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String celsiusStr = txtCel.getText().toString();
                if (!celsiusStr.isEmpty()) {
                    double celsius = Double.parseDouble(celsiusStr);
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    txtFar.setText(String.valueOf(fahrenheit));
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtFar.setText("");
                txtCel.setText("");
            }
        });
        btnBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BMIActivity.class);
                startActivity(intent);
            }
        });
    }
}
