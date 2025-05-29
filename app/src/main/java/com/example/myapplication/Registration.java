package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {
      EditText firstName,secondName,email,phone;
      Button button;
      RadioButton male,female;
      String strFirstName,strSecondName,strEmail,strPhone;
      Bean bean;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
       firstName=findViewById(R.id.firstName);
       secondName=findViewById(R.id.secondName);
       email=findViewById(R.id.email);
       phone=findViewById(R.id.phone);
       button=findViewById(R.id.button);
       male=findViewById(R.id.male);
       female=findViewById(R.id.female);

       button.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view){
              strFirstName=firstName.getText().toString();
              strSecondName=secondName.getText().toString();
              strEmail=email.getText().toString();
              strPhone=phone.getText().toString();
               Toast.makeText(getApplicationContext(), strFirstName, Toast.LENGTH_SHORT).show();
               firstName.setText("");
               secondName.setText("");
               email.setText("");
               phone.setText("");
               bean=new Bean(strFirstName,strSecondName,strEmail,strPhone);

               // Write a message to the database
               FirebaseDatabase database = FirebaseDatabase.getInstance();
               DatabaseReference myRef = database.getReference("message");

               myRef.setValue("Hello, World!");
       }

    });
}
}