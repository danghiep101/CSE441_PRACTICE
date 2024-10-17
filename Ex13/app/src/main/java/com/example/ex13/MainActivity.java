package com.example.ex13;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView selection;
    // Khai báo 2 CompleteTextView
    AutoCompleteTextView singleComplete;
    MultiAutoCompleteTextView multiComplete;
    // Khởi tạo mảng tên địa danh
    String arr[] = {"hà nội", "huế", "sài gòn",
            "hà giang", "nghệ an", "kiên giang",
            "lâm đồng", "long khánh"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selection = (TextView) findViewById(R.id.selection);
        singleComplete = (AutoCompleteTextView) findViewById(R.id.editauto);
        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arr
        );
        singleComplete.setAdapter(myadapter);

        multiComplete = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);
        multiComplete.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arr
        ));
        multiComplete.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        singleComplete.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                selection.setText(singleComplete.getText());
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
}
