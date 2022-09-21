package com.example.lesson_6;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableWrapper;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lesson_6.R;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private Button enter;
    private EditText email, password;
    private TextView textView, text1,text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enter = findViewById(R.id.Enter);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        textView = findViewById(R.id.text_view);
        text1 = findViewById(R.id.text1);
        text2 =  findViewById(R.id.text2);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (email.getText().toString().equals("")) {
                    enter.setBackgroundColor(Color.GRAY);
                } else {
                    enter.setBackgroundColor(Color.YELLOW);
                }
            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (password.getText().toString().equals("")) {
                    enter.setBackgroundColor(Color.GRAY);
                } else {
                    enter.setBackgroundColor(Color.YELLOW);
                }
            }
        });
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().equals("admin") | password.getText().toString().equals("admin")){
                    Toast.makeText(MainActivity.this,"Вы успешно зарегистрировались!",Toast.LENGTH_SHORT).show();
                    textView.setVisibility(View.GONE);
                    text1.setVisibility(View.GONE);
                    text2.setVisibility(View.GONE);
                    email.setVisibility(View.GONE);
                    password.setVisibility(View.GONE);
                    enter.setVisibility(View.GONE);
                } else{
                    Toast.makeText(MainActivity.this,"Неправильный логин и пароль",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}