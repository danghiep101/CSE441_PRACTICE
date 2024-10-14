package com.example.btth03.ui.addittion;

public interface Filter {
    boolean isFieldEmpty(String data);

    boolean isCorrectDateFormat(String data);

    boolean isCorrectGpaFormat(String data);

    boolean isStudentExisted(String id);
}
