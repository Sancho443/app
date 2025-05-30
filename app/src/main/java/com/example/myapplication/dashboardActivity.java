package com.example.myapplication;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class dashboardActivity extends AppCompatActivity {
    ImageView send;
    EditText phoneNumber;
    TextView txtname,txtemail,txtphone;
    LinearLayout layout1,layout2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        txtname=findViewById(R.id.name);
        txtemail=findViewById(R.id.email);
        txtphone =findViewById(R.id.phone);
        layout1=findViewById(R.id.layout1);
        layout2=findViewById(R.id.layout2);



        phoneNumber=findViewById(R.id.phoneNumberChecker);
        send=findViewById(R.id.SearchButton);

       send.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               retriveFromFirebase();
           }


       });
    }

    private void retriveFromFirebase() {
        String strphone= phoneNumber.getText().toString().trim();
        Toast.makeText(getApplicationContext(), strphone, Toast.LENGTH_SHORT).show();
        // Read from the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(strphone);



        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Bean results = dataSnapshot.getValue(Bean.class);
                String name= results.getFirstName()+ " "+ results.getSecondName();
                String email= results.getEmail();
                String phone= results.getPhone();
                txtname.setText(name);
                txtemail.setText(email);
                txtphone.setText(phone);

                layout1.setVisibility(View.GONE);
                layout2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }


};


