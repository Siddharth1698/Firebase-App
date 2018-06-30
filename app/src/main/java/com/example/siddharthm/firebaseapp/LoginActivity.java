package com.example.siddharthm.firebaseapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    Button button;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText1 = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button);
        mAuth = FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignIn();

            }
        });
    }

    private void startSignIn() {
        String username = editText1.getText().toString();
        String password = editText2.getText().toString();
        if (username.isEmpty() && password.isEmpty()) {
            Toast.makeText(LoginActivity.this,"Feilds are empty",Toast.LENGTH_SHORT).show();

        } else{
            mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(LoginActivity.this, "Signin issue", Toast.LENGTH_SHORT).show();
                    } else {
                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user!=null){
                            Intent intent = new Intent(getApplicationContext(),RetriveData.class);
                            startActivity(intent);
                        }

                    }
                }
            });
        }
    }
}