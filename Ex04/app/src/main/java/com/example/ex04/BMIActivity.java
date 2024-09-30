package com.example.ex04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class BMIActivity extends AppCompatActivity {

    private EditText edtTen, editChieuCao, edtCanNang, edtBMI, edtChuanDoan;
    private Button btnBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);

        edtTen = findViewById(R.id.edtTen);
        editChieuCao = findViewById(R.id.editChieuCao);
        edtCanNang = findViewById(R.id.edtCanNang);
        edtBMI = findViewById(R.id.edtBMI);
        edtChuanDoan = findViewById(R.id.edtChuanDoan);
        btnBMI = findViewById(R.id.btnBMI);

        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chieuCaoStr = editChieuCao.getText().toString();
                String canNangStr = edtCanNang.getText().toString();

                if (!chieuCaoStr.isEmpty() && !canNangStr.isEmpty()) {
                    double chieuCao = Double.parseDouble(chieuCaoStr);
                    double canNang = Double.parseDouble(canNangStr);

                    if (chieuCao > 0) {
                        double bmi = canNang / (chieuCao * chieuCao);
                        edtBMI.setText(String.valueOf(bmi));

                        String chuanDoan;
                        if (bmi < 18.5) {
                            chuanDoan = "Gầy";
                        } else if (bmi < 24.9) {
                            chuanDoan = "Bình thường";
                        } else if (bmi < 29.9) {
                            chuanDoan = "Thừa cân";
                        } else {
                            chuanDoan = "Béo phì";
                        }

                        edtChuanDoan.setText(chuanDoan);
                    }
                }
            }
        });
    }
}

