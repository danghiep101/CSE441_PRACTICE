package com.example.btth03.ui.studentdetail;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.btth03.R;
import com.example.btth03.Utils.utils;
import com.example.btth03.data.model.Student;

public class StudentDetailActivity extends AppCompatActivity {
    private TextView textStudentId;
    private TextView textFullName;
    private TextView textAddress;
    private TextView textEmail;
    private TextView textMajor;
    private TextView textBirthDate;
    private TextView textGpa;
    private TextView textYear;
    private TextView textGender;
    private ImageView imageAvartar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);
        setTitle(getString(R.string.title_detail));
        initViews();
        StudentDetailObserver observer = new StudentDetailObserver(this, this::showData);
        getLifecycle().addObserver(observer);
    }

    private void initViews() {
        imageAvartar = findViewById(R.id.image_avartar_detail);
        textStudentId = findViewById(R.id.text_id_detail);
        textFullName = findViewById(R.id.text_full_name_detail);
        textBirthDate = findViewById(R.id.text_birth_date_detail);
        textAddress = findViewById(R.id.text_address_detail);
        textGpa = findViewById(R.id.text_gpa_detail);
        textGender = findViewById(R.id.text_gender_detail);
        textEmail = findViewById(R.id.text_email_detail);
        textMajor = findViewById(R.id.text_major_detail);
        textYear = findViewById(R.id.text_year_detail);
    }

    @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables"})
    private void showData(Student student) {
        if (student == null) {
            imageAvartar.setImageDrawable(getDrawable(R.drawable.ic_error_24));
            textStudentId.setText(getString(R.string.text_no_data));
        } else {
            imageAvartar.setImageDrawable(
                    utils.getDrawable(this, student.getGender()));
            textStudentId.setText(
                    utils.concatString(getString(R.string.text_id),
                            student.getStudentId()));
            textFullName.setText(
                    utils.concatString(getString(R.string.text_fullname),
                            student.getFullName()));
            textGender.setText(
                    utils.concatString(getString(R.string.text_gender),
                            student.getGender()));
            textAddress.setText(
                    utils.concatString(getString(R.string.text_address),
                            student.getAddress()));
            textEmail.setText(
                    utils.concatString(getString(R.string.text_email),
                            student.getEmail()));
            textBirthDate.setText(
                    utils.concatString(getString(R.string.text_birth_date),
                            utils.dateToString(student.getBirthDate())));
            textGpa.setText(
                    utils.concatString(getString(R.string.text_gpa),
                            student.getGpa()));
            textYear.setText(
                    utils.concatString(getString(R.string.text_year),
                            student.getYear()));
            textMajor.setText(
                    utils.concatString(getString(R.string.text_major),
                            student.getMajor()));
        }
    }

    public interface OnDataItemCaptureListener {
        void onDataCaptured(Student student);
    }
}