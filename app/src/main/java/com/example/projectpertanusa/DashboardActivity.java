package com.example.projectpertanusa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    private TextView NIK,Password;
    private Button btn_logout;
    private SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        NIK = findViewById(R.id.tv_nik);
        Password = findViewById(R.id.tv_pass);
        btn_logout = findViewById(R.id.btn_logout);

        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        if (!sharedPrefManager.isUserLoggedIn()){
            startActivity(new Intent(DashboardActivity.this,LoginActivity.class));
            finish();
        }

        UserModel user = sharedPrefManager.getUserLogin();
//        NIK.setText("Key : "+user.getUserNIK());
//        Password.setText("User : "+user.getUserName());

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPrefManager.userlogout();
                startActivity(new Intent(DashboardActivity.this,LoginActivity.class));
                finish();
            }
        });
    }



}