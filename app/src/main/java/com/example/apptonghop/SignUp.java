package com.example.apptonghop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {
    private TextView dn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        dn= (TextView) findViewById(R.id.dangnhap);
        dn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMainActivity();
            }
        });
    }
    public void  openMainActivity(){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}