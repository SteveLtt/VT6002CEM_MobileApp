package com.example.mobileapp_;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView reg;

    private EditText editTextemail, editTextpwd;
    private Button login;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        reg = (TextView) findViewById(R.id.reg);
        reg.setOnClickListener(this);

        login =(Button) findViewById(R.id.signin);
        login.setOnClickListener(this);

        editTextemail = (EditText) findViewById(R.id.email);
        editTextpwd= (EditText) findViewById(R.id.pwd);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.reg:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.signin:
                userLogin();
                break;
        }


    }

    private void userLogin() {
        String email = editTextemail.getText().toString().trim();
        String password = editTextpwd.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(LoginActivity.this,ProfileActivity.class));
                }else{
                    Toast.makeText(LoginActivity.this,"Failed to login!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}