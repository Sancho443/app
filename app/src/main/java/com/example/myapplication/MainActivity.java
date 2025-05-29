package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void profile(View view){
        Toast.makeText(getApplicationContext(), "profile clicked", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(),Registration.class);
        startActivity(intent);
    }
    public void email(View view){
        Toast.makeText(getApplicationContext(), "email clicked", Toast.LENGTH_SHORT).show();
    }
}