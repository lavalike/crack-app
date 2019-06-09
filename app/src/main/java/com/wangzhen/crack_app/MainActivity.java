package com.wangzhen.crack_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.input_age);
        findViewById(R.id.btn_check_age).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int age = Integer.parseInt(editText.getText().toString());
        if (age >= 18) {
            Toast.makeText(this, "您成年了", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "您未成年", Toast.LENGTH_SHORT).show();
        }
    }
}
