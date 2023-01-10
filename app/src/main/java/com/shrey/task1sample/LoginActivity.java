package com.shrey.task1sample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username,passfile;
    Button button;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        username = findViewById(R.id.username);
        username = findViewById(R.id.username);
        passfile = findViewById(R.id.passfile);
        button = findViewById(R.id.button);
        setContentView(R.layout.activity_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = username.getText().toString();
                String pass = passfile.getText().toString();
                boolean check = validateinfo(name, pass);
                if (check == true){
                    Toast.makeText(getApplicationContext(),"Data is Valid", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getApplicationContext(),"Sorry check information again",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private boolean validateinfo(String name, String pass) {
        if (name.length() == 0){
            username.requestFocus();
            username.setError("Field can not be empty");
            return false;
        }else if(!name.matches("[a-zA-Z]+")){
            username.requestFocus();
            username.setError("Enter Only Alphabetical Character");
            return false;
        }else if(pass.length()<=5){
            passfile.requestFocus();
            passfile.setError("Minimum 6 character required");
        }
        return true;
    }

}