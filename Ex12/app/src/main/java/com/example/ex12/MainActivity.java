package com.example.ex12;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends Activity {


    ArrayAdapter<String> arrAdapater; EditText edtwork,edth,edtm; TextView txtdate;
    Button btnwork;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edth = findViewById(R.id.edthour); edtm = findViewById(R.id.edtmi); edtwork = findViewById(R.id.edtwork); btnwork = findViewById(R.id.btnadd);
       ListView lv = findViewById(R.id.listView1); txtdate = findViewById(R.id.txtdate);

        ArrayList arraywork = new ArrayList<>();
        arrAdapater = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arraywork);

        lv.setAdapter(arrAdapater);

        Date currentDate = Calendar.getInstance().getTime();

        txtdate.setText("Hôm Nay: "+ simpleDateFormat.format(currentDate));
        btnwork.setOnClickListener(new  View.OnClickListener()  {

            @Override
            public void onClick(View v) {
                if(edtwork.getText().toString().equals("")||edth.getText().toString().equals("")
                        ||edtm.getText().toString().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this); builder.setTitle("Info missing");
                    builder.setMessage("Please enter all information of the work"); builder.setPositiveButton("Continue",  new  DialogInterface.OnClickListener()  {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.show();
                }
                else {
                    String str = edtwork.getText().toString() + " - "+
                            edth.getText().toString()  +  ":"+edtm.getText().toString();

                    arraywork.add(str);
                    edtm.setText(""); edtwork.setText("");
                }
            }
        });
    }
}

