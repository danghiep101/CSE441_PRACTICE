package com.example.btth03.Utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;


import com.example.btth03.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class utils {
    public static final String EXTRA_STUDENT_ID = "EXTRA_STUDENT_INDEX";
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    @SuppressLint("SimpleDateFormat")
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);


    @SuppressLint("UseCompatLoadingForDrawables")
    public static Drawable getDrawable(Context context, String gender) {
        if (gender.compareTo("Nam") == 0) {
            return context.getResources().getDrawable(R.drawable.ic_man_24);
        } else {
            return context.getDrawable(R.drawable.ic_woman_24);
        }
    }


    public static Date stringToDate(String dateStr) {
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }


    public static String dateToString(Date date) {
        return dateFormat.format(date);
    }

    public static String concatString(String str1, Object obj) {
        return str1 + " " + obj.toString();
    }
}
