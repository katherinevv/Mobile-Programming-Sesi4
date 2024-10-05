package com.example.sesi_4_kath;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {
    TextView homeNameTV, homeRoleIdTV;
    GridView listView;
    int[] imageList = {R.drawable.baseline_home_24, R.drawable.baseline_calendar_month_24, R.drawable.baseline_book_24,
            R.drawable.baseline_account_balance_wallet_24, R.drawable.baseline_settings_24, R.drawable.baseline_logout_24};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        homeNameTV = findViewById(R.id.homeNameTV);
        homeRoleIdTV = findViewById(R.id.homeRoleIdTV);

        //Receive Value
        Intent receiveIntent = getIntent();
        String name = receiveIntent.getStringExtra("inputName");
        String binusianId = receiveIntent.getStringExtra("inputBinusianId");
        String role = receiveIntent.getStringExtra("inputRole");

        homeNameTV.setText(name);
        homeRoleIdTV.setText(role + " - " + binusianId);

        //Grid View
        listView = findViewById(R.id.homeGridView);

        CustomAdapter adapter = new CustomAdapter(this, imageList);
        listView.setAdapter(adapter);
    }
}
