package com.example.ex05;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ptb2 extends AppCompatActivity {

    EditText inputA, inputB, inputC;
    TextView result;
    Button btnSolve, btnContinue, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptb2);

        inputA = findViewById(R.id.input_a);
        inputB = findViewById(R.id.input_b);
        inputC = findViewById(R.id.input_c);
        result = findViewById(R.id.result);
        btnSolve = findViewById(R.id.btn_solve);
        btnContinue = findViewById(R.id.btn_continue);
        btnExit = findViewById(R.id.btn_exit);

        btnSolve.setOnClickListener(v -> {
            solveEquation();
        });

        btnContinue.setOnClickListener(v -> {
            clearFields();
        });

        btnExit.setOnClickListener(v -> {
            finish();
        });
    }

    private void solveEquation() {
        double a = Double.parseDouble(inputA.getText().toString());
        double b = Double.parseDouble(inputB.getText().toString());
        double c = Double.parseDouble(inputC.getText().toString());

        double delta = b * b - 4 * a * c;
        if (delta < 0) {
            result.setText("Phương trình vô nghiệm");
        } else if (delta == 0) {
            double x = -b / (2 * a);
            result.setText("Phương trình có nghiệm kép: x1 = x2 = " + x);
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            result.setText("Phương trình có 2 nghiệm: x1 = " + x1 + ", x2 = " + x2);
        }
        result.setVisibility(View.VISIBLE);
    }

    private void clearFields() {
        inputA.setText("");
        inputB.setText("");
        inputC.setText("");
        result.setVisibility(View.GONE);
        inputA.requestFocus();
    }
}
