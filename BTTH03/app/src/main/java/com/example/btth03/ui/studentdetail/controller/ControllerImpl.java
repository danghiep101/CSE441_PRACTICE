package com.example.btth03.ui.studentdetail.controller;


import com.example.btth03.data.model.Student;

import java.util.List;

public class ControllerImpl implements Controller {
    @Override
    public Student findById(List<Student> students, String id) {
        if (students.contains(new Student(id))) {
            for (Student student : students) {
                if (student.getStudentId().compareTo(id) == 0) {
                    return student;
                }
            }
        }
        return null;

    }
}
