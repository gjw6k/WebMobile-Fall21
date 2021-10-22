package com.example.loginpage;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class second extends AppCompatActivity {

    public void logout(View view) {
        TextView textView =(TextView) findViewById(R.id.textView4);
        loginActivity();
    }
public void loginActivity() {
    Intent main = new Intent(this,MainActivity.class);
    startActivity(main);
}





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
    }
}