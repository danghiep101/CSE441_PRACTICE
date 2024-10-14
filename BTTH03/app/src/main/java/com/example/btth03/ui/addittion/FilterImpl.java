package com.example.btth03.ui.addittion;
import com.example.btth03.ui.StudentList.StudentViewModel;
import com.example.btth03.ui.studentdetail.controller.Controller;
import com.example.btth03.ui.studentdetail.controller.ControllerImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterImpl implements Filter {
    @Override
    public boolean isFieldEmpty(String data) {
        return data.trim().length() == 0;
    }

    @Override
    public boolean isCorrectDateFormat(String data) {
        String format = "\\d{2}/\\d{2}/\\d{4}";
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

    @Override
    public boolean isCorrectGpaFormat(String data) {
        String format = "\\d.\\d{1,2}";
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(data);
        if (matcher.matches()) {
            float gpa = Float.parseFloat(data);
            return gpa <= 4.0 && gpa >= 0;
        }
        return false;
    }

    @Override
    public boolean isStudentExisted(String id) {
        Controller controller = new ControllerImpl();
        return controller.findById(
                StudentViewModel.getInstance()
                        .getStudents().getValue(), id) != null;
    }
}
