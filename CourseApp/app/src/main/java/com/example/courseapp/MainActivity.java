package com.example.courseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etstName,etUserName, etPassword;
    Button btnLogIn;
public static String stuName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etstName=findViewById(R.id.stName);
        etUserName = findViewById(R.id.UserName);
        etPassword = findViewById(R.id.password);

        btnLogIn = findViewById(R.id.login);

        btnLogIn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        stuName = etstName.getText().toString();
        String user = etUserName.getText().toString();
        String pass = etPassword.getText().toString();
        if (user.equals("student1") && pass.equals("123456") && !stuName.equals("") ) {

            Intent act = new Intent(getApplicationContext(), Main2Activity.class);
            startActivity(act);
        } else
            Toast.makeText(getApplicationContext(), "Invalid user name or password or Enter student name", Toast.LENGTH_LONG).show();
    }

}
