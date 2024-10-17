package com.example.ex13;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String namephone[] ={"Điện thoại Iphone 12", "Điện thoại SamSung S20","Điện thoại Nokia 6","Điện thoại Bphone 2020","Điện thoại Oppo 5","Điện thoại VSmart joy2"};
    int imagephone[] = {R.drawable.mexico,R.drawable.nigeria,R.drawable.russia,R.drawable.united_states, R.drawable.vietnam,R.drawable.pakistan};
    ArrayList<phone> mylist;
    @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
        ListView lv = findViewById(R.id.lv);
        mylist = new ArrayList<>();
        for (int i = 0; i <namephone.length;i++)
        {

            mylist.add(new phone(namephone[i],imagephone[i]));
        }
        ArrayAdapter<String> myadapter;
            myadapter  =  new  MyArrayAdapter(this,R.layout.layout_listview,mylist);
            lv.setAdapter(myadapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent myintent = new Intent(MainActivity.this, SubActivity.class); myintent.putExtra("name",namephone[i]);
                    startActivity(myintent);
                }

        });
    }
}

