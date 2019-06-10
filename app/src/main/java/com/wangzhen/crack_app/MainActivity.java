package com.wangzhen.crack_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.input_age);
        textView = findViewById(R.id.tv_result);
        findViewById(R.id.btn_check_age).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (TextUtils.isEmpty(editText.getText()))
            return;
        int age = Integer.parseInt(editText.getText().toString());
        String result;
        if (age >= 18) {
            result = "您成年了";
        } else {
            result = "您未成年";
        }
        textView.setText(result);
    }
}
