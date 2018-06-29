package com.example.siddharthm.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    Button mSendData;
    EditText mtKey;
    EditText mtValue;
    private DatabaseReference mDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSendData = (Button)findViewById(R.id.addString);
        mtKey = (EditText) findViewById(R.id.keytext);
        mtValue = (EditText)findViewById(R.id.valuetext);

        final DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();



        mSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = (String) mtKey.getText().toString();
                String value = (String) mtValue.getText().toString();
                DatabaseReference child = mRef.child(key);
                child.setValue(value);


            }
        });

    }
}
