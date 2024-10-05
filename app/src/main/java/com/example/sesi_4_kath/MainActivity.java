package com.example.sesi_4_kath;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText mainNameET, mainBinusIdET;
    Spinner mainRoleSpn;
    Button mainRegisterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mainNameET = findViewById(R.id.mainNameET);
        mainBinusIdET = findViewById(R.id.mainBinusianIdET);
        mainRoleSpn = findViewById(R.id.mainRoleSpn);
        mainRegisterBtn = findViewById(R.id.mainRegisterBtn);

        //Move Page
        mainRegisterBtn.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View view) {
        String name = mainNameET.getText().toString();
        String binusianId = mainBinusIdET.getText().toString();
        String role = mainRoleSpn.getSelectedItem().toString();

        Intent moveIntent = new Intent(MainActivity.this, HomeActivity.class);
        moveIntent.putExtra("inputName", name);
        moveIntent.putExtra("inputBinusianId", binusianId);
        moveIntent.putExtra("inputRole", role);

        startActivity(moveIntent);
        finish();
    }
}