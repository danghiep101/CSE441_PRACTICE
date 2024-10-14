package com.example.btth03.ui.studentdetail;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

import com.example.btth03.Utils.utils;
import com.example.btth03.ui.studentdetail.controller.Controller;
import com.example.btth03.ui.studentdetail.controller.ControllerImpl;
import com.example.btth03.data.model.Student;
import com.example.btth03.ui.StudentList.StudentViewModel;

import java.util.List;
import java.util.Objects;

public class StudentDetailObserver implements DefaultLifecycleObserver {
    private final Context context;
    private final StudentDetailActivity.OnDataItemCaptureListener listener;

    public StudentDetailObserver(Context context,
                                 StudentDetailActivity.OnDataItemCaptureListener listener) {
        this.context = context;
        this.listener = listener;
    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        DefaultLifecycleObserver.super.onCreate(owner);
        Intent intent = ((StudentDetailActivity) context).getIntent();
        StudentViewModel model = StudentViewModel.getInstance();
        String studentId = intent.getStringExtra(utils.EXTRA_STUDENT_ID);
        if (studentId != null) {
            List<Student> students = Objects.requireNonNull(model.getStudents().getValue());
            Controller controller = new ControllerImpl();
            listener.onDataCaptured(controller.findById(students, studentId));
        } else {
            listener.onDataCaptured(null);
        }
    }
}
