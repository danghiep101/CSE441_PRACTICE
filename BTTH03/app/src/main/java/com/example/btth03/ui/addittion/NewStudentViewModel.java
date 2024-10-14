package com.example.btth03.ui.addittion;

import androidx.lifecycle.ViewModel;

import com.example.btth03.Utils.utils;
import com.example.btth03.data.model.Student;
import com.example.btth03.ui.StudentList.StudentViewModel;

public class NewStudentViewModel extends ViewModel {
    private final Filter filter;
    private static NewStudentViewModel instance;

    private NewStudentViewModel() {
        filter = new FilterImpl();
    }

    public static NewStudentViewModel getInstance() {
        if (instance == null) {
            instance = new NewStudentViewModel();
        }
        return instance;
    }

    public boolean checkGpa(String gpa) {
        return filter.isCorrectGpaFormat(gpa);
    }

    public boolean checkBirthDate(String birthDate) {
        return filter.isCorrectDateFormat(birthDate);
    }

    public boolean checkStringIsEmpty(String data) {
        return filter.isFieldEmpty(data);
    }

    public boolean checkStudentExisted(String id) {
        return filter.isStudentExisted(id);
    }

    public void addNewStudent(String id, String fullName, String address,
                              String email, String major, String gpa,
                              String gender, String year, String birthDate) {
        Student student = new Student(id);
        student.setFullName(fullName);
        student.setAddress(address);
        student.setEmail(email);
        student.setGender(gender);
        student.setGpa(Float.parseFloat(gpa));
        student.setMajor(major);
        student.setYear(Integer.parseInt(year));
        student.setBirthDate(utils.stringToDate(birthDate));
        StudentViewModel.getInstance().addStudent(student);
    }
}
