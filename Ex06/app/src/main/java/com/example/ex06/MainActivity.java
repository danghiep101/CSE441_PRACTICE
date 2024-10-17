package com.example.ex06;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputName, inputID, inputAdditionalInfo;
    RadioGroup radioEducation;
    CheckBox checkboxDocBao, checkboxDocSach, checkboxCoding;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputName = findViewById(R.id.input_name);
        inputID = findViewById(R.id.input_id);
        radioEducation = findViewById(R.id.radio_education);
        checkboxDocBao = findViewById(R.id.checkbox_docbao);
        checkboxDocSach = findViewById(R.id.checkbox_docsach);
        checkboxCoding = findViewById(R.id.checkbox_coding);
        inputAdditionalInfo = findViewById(R.id.input_additional_info);
        btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitInformation();
            }
        });
    }

    private void submitInformation() {
        String name = inputName.getText().toString().trim();
        String id = inputID.getText().toString().trim();
        String additionalInfo = inputAdditionalInfo.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(id) || id.length() != 9) {
            Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton selectedEducation = findViewById(radioEducation.getCheckedRadioButtonId());
        String educationLevel = selectedEducation.getText().toString();

        StringBuilder hobbies = new StringBuilder();
        if (checkboxDocBao.isChecked()) {
            hobbies.append("Đọc báo, ");
        }
        if (checkboxDocSach.isChecked()) {
            hobbies.append("Đọc sách, ");
        }
        if (checkboxCoding.isChecked()) {
            hobbies.append("Đọc coding, ");
        }

        if (hobbies.length() > 0) {
            hobbies.setLength(hobbies.length() - 2); // Remove trailing comma
        }


        String message = "Họ tên: " + name + "\n"
                + "CMND: " + id + "\n"
                + "Trình độ: " + educationLevel + "\n"
                + "Sở thích: " + hobbies + "\n"
                + "Thông tin bổ sung: " + additionalInfo;


        new AlertDialog.Builder(this)
                .setTitle("Thông tin cá nhân")
                .setMessage(message)
                .setPositiveButton("Đóng", null)
                .show();
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}
