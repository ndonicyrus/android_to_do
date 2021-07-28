package com.example.todoapp.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.todoapp.R;
import com.example.todoapp.ToDoActivity;
import com.example.todoapp.auth.ui.login.LoginActivity;
import com.example.todoapp.settings.SharedPrefConfig;

public class RegisterActivity extends AppCompatActivity {

    EditText inputName, inputNumber, inputEmail , inputPassword, inputConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputName = findViewById(R.id.input_name);
        inputNumber = findViewById(R.id.input_number);
        inputEmail= findViewById(R.id.input_email);
        inputPassword = findViewById(R.id.input_password);
        inputConfirm = findViewById(R.id.input_confirm);
        final Button loginButton = findViewById(R.id.btn_log);
        final Button registerButton = findViewById(R.id.btn_reg);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * Adding function to register a user
                 */

                registerUser();
            }
        });
    }

    private void registerUser() {
        String name,number,email,password,confirm;
        name = inputName.getText().toString().trim();
        number = inputNumber.getText().toString().trim();
        email = inputEmail.getText().toString().trim();
        password = inputPassword.getText().toString().trim();
        confirm = inputConfirm.getText().toString().trim();

        SharedPrefConfig sharedPrefConfig = new SharedPrefConfig(RegisterActivity.this);
        sharedPrefConfig.setUserInfo(name, email, number, password);

        Toast.makeText(this, "User"+" "+name+" "+"registered successfully.", Toast.LENGTH_SHORT).show();


        Intent intent = new Intent(RegisterActivity.this, ToDoActivity.class);
        startActivity(intent);

    }

}