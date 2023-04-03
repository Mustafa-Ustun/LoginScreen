package com.example.loginscreen;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btnLogin, btnRegistr;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.LoginUsername);
        password = (EditText) findViewById(R.id.LoginPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegistr = (Button) findViewById(R.id.btnRegister);
        DB = new DBHelper(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Lütfen bütün verileri giriniz", Toast.LENGTH_SHORT).show();
                else {
                    boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if (checkuserpass) {
                        Toast.makeText(LoginActivity.this, "Giriş Yapıldı", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Page.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Giriş Başarısız", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        btnRegistr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent = new Intent(getApplicationContext(),MainActivity.class);
             startActivity(intent);
            }
        });
    }
}