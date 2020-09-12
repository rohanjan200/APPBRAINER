package com.example.addition;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
 EditText num1,num2;
 TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result= findViewById(R.id.result);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                {
                if(!num1.getText().toString().equals(" ")&& !num2.getText().toString().equals(" "))
                {
                 int temp1 = Integer.parseInt(num1.getText().toString());
                    int temp2 = Integer.parseInt(num2.getText().toString());
                    result.setText(String.valueof(temp1+temp2));

                }
            }


            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
            num1.addTextChangedListener(textWatcher);
            num2.addTextChangedListener(textWatcher);
    }
}