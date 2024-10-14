package com.example.btth03.ui.studentdetail.controller;

import com.example.btth03.data.model.Student;


import java.util.List;

public interface Controller {
    Student findById(List<Student> students, String id);
}
