package com.example.studentrate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button bt_login;
    TextInputLayout textInputLayoutUsername, textInputLayoutPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
        bt_login = findViewById(R.id.btn_login);
        textInputLayoutUsername = findViewById(R.id.layoutUsrname);
        textInputLayoutPassword = findViewById(R.id.layoutPassword);

        Login();

    }

    private void Login() {
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().trim().isEmpty()) {
                    Snackbar snackbar = Snackbar.make(view, "Please fill out these fields", Snackbar.LENGTH_SHORT);
                    View snackbarView = snackbar.getView();
                    snackbarView.setBackgroundColor(getResources().getColor(R.color.Red));
                    snackbar.show();
                    textInputLayoutUsername.setError("Username should not be empty");
                    textInputLayoutPassword.setError("Password should not be empty");
                }
                if ( password.getText().toString().trim().isEmpty()){
                    Snackbar snackbar = Snackbar.make(view, "Please fill out these fields", Snackbar.LENGTH_SHORT);
                    View snackbarView = snackbar.getView();
                    snackbarView.setBackgroundColor(getResources().getColor(R.color.Red));
                    snackbar.show();
                    textInputLayoutPassword.setError("Password should not be empty");
                }
            }
        });

    }
}
