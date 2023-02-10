package com.example.projectpertanusa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText NIK,Password;
    private Button btn_login;
    private ProgressDialog progressDialog;
    private SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.Btn_Login);
        NIK = findViewById(R.id.edt_nik);
        Password = findViewById(R.id.edt_pass);
        //
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Tunggu sebentar...");
        progressDialog.setCancelable(false);
        //
        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        Boolean isLoggedIn = sharedPrefManager.isUserLoggedIn();

        if (isLoggedIn){
            startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
            finish();
        }else{
            btn_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    progressDialog.show();
                    String nik = NIK.getText().toString();
                    String pass = Password.getText().toString();

                    if (nik.equals("1111") && pass.equals("123")){
                        //
                        UserModel user = new UserModel(nik, "Samsul hadi");
                        sharedPrefManager.setUserLogin(user,true);
                        //
                        startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                        finish();
                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(LoginActivity.this, "nik/passwordd tidak ditemukan!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }



    public void button_regsiterhere(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }


}