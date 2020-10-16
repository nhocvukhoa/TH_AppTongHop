package com.example.apptonghop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView dk;
    private Button sg;
    private CheckBox showpass;
    private EditText username,password;
    String correct_username= "admin";
    String correct_password= "12345";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dk= (TextView) findViewById(R.id.dangki);
        dk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openSignUp();
            }
        });
        sg= (Button) findViewById(R.id.signin);
        sg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                openProfile();
                if(TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(MainActivity.this, "Bạn chưa điền. Mời nhập lại",Toast.LENGTH_LONG).show();
                } else if(username.getText().toString().equals(correct_username)){
                    if(password.getText().toString().equals(correct_password)){
                        Toast.makeText(MainActivity.this, "Đăng nhập thành công",Toast.LENGTH_LONG).show();
                        openProfile();
                    }else{
                        Toast.makeText(MainActivity.this, "Sai tên đăng nhập hoặc mật khẩu. Nhập lại",Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Sai tên đăng nhập hoặc mật khẩu. Nhập lại",Toast.LENGTH_LONG).show();
                }

            }
        });

        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        showpass=(CheckBox) findViewById(R.id.showpass);
        showpass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

    }
    public void openSignUp(){
        Intent intent=new Intent(this, SignUp.class);
        startActivity(intent);
    }
    public void openProfile(){
        Intent intent=new Intent(this, Profile.class);
        startActivity(intent);
    }
}