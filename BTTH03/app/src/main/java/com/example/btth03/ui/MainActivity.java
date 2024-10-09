package com.example.btth03.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btth03.R;
import com.example.btth03.Utils.utils;
import com.example.btth03.data.model.Student;



import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerViewStudent;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.title_student_list));
        addRecyclerView();

    }



    private void addRecyclerView() {

        recyclerViewStudent = findViewById(R.id.recyclerView);

        StudentAdapter adapter = new StudentAdapter(this, new ArrayList<>(),
                this::createDetailActivity);
        recyclerViewStudent.setAdapter(adapter);

        StudentViewModel model = StudentViewModel.getInstance();
        model.getStudents().observe(this, adapter::setStudents);
        model.loadData(getApplicationContext());

        recyclerViewStudent.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewStudent.setHasFixedSize(true);
    }


    private void createDetailActivity(Student student) {
        Intent intent = new Intent(this, StudentDetailActivity.class);
        intent.putExtra(utils.EXTRA_STUDENT_ID, student.getStudentId());
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, NewStudentActivity.class);
        startActivity(intent);
    }
}