package com.example.btth03.ui;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.btth03.data.model.Student;
import com.example.btth03.parser.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class StudentViewModel extends ViewModel {
    private static StudentViewModel instance;
    private final MutableLiveData<List<Student>> liveDataStudent;
    private final List<Student> studentList;

    private StudentViewModel() {
        studentList = new ArrayList<>();
        liveDataStudent = new MutableLiveData<>();
    }

    public static StudentViewModel getInstance() {
        if (instance == null) {
            instance = new StudentViewModel();
        }
        return instance;
    }

    public LiveData<List<Student>> getStudents() {
        return liveDataStudent;
    }

    public void loadData(Context context) {

        JsonParser parser = new JsonParser();
        String jsonString = parser.getDataFromJson(context);
        if (jsonString != null) {
            studentList.clear();
            studentList.addAll(parser.getStudents(jsonString));
            if (studentList.size() != 0) {
                liveDataStudent.setValue(studentList);
            }
        }
    }

    public void addStudent(Student student) {

        studentList.add(student);
        liveDataStudent.setValue(studentList);
    }
}
