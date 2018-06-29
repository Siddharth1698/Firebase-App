package com.example.siddharthm.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    Button mSendData;
    EditText mtText;
    private DatabaseReference mDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSendData = (Button)findViewById(R.id.addString);
        mtText = (EditText)findViewById(R.id.editText);
        final DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();



        mSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference mRefChild = mRef.child("new");
                mRefChild.setValue("neww");


            }
        });

    }
}
