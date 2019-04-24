package com.example.klear2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.klear2.R;

public class LoginActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;
    private ImageView Klear;
    private TextView tvInfo;
    private int counter =5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Login = (Button)findViewById(R.id.btLogin);
        Klear = (ImageView)findViewById(R.id.image);
        tvInfo= (TextView)findViewById(R.id.tvInfo);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText(). toString(), Password.getText().toString());
            }
        });
    }

    private void validate (String userName, String userPassword){
        if((userName == "Admin") && (userPassword == "1234")){
            Intent intent = new Intent (LoginActivity.this,MenuActivity.class);
            startActivity(intent);
        }else{
            counter--;

            tvInfo.setText("No. of attempts remaining:" + String.valueOf(counter));

            if(counter ==0){
                Login.setEnabled(false);
            }
        }
    }}


