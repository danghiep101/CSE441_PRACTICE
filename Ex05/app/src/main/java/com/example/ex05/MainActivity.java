package com.example.ex05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText inputSolarYear;
    TextView resultLunarYear;
    Button btnConvert, btnPTB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputSolarYear = findViewById(R.id.input_solar_year);
        resultLunarYear = findViewById(R.id.result_lunar_year);
        btnConvert = findViewById(R.id.btn_convert);
        btnPTB2 = findViewById(R.id.button);
        btnConvert.setOnClickListener(v -> {
            convertToLunarYear();
        });
        btnPTB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.
                        this, Ptb2.class);
                startActivity(intent);
            }
        });
    }

    private void convertToLunarYear() {
        int solarYear = Integer.parseInt(inputSolarYear.getText().toString());
        String lunarYear = getLunarYear(solarYear);
        resultLunarYear.setText("Âm lịch: " + lunarYear);
        resultLunarYear.setVisibility(View.VISIBLE);
    }

    private String getLunarYear(int solarYear) {
        String[] can = {"Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ"};
        String[] chi = {"Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi"};

        int canIndex = solarYear % 10;
        int chiIndex = solarYear % 12;

        return can[canIndex] + " " + chi[chiIndex];
    }
}
