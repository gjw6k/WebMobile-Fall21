package com.example.loginpage;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
public void userLoigin (View view) {
    EditText userName = (EditText) findViewById(R.id.userName);
    EditText userPassword = (EditText) findViewById(R.id.userPassword);
    Button button = findViewById(R.id.loginButton);
    String user = userName.getText().toString();
    String pass = userPassword.getText().toString();
    if (user.equals("jay") && pass.equals("papa")) {
                                          otherActivity();
                                      }
                                      else {

                                              new AlertDialog.Builder(this)
                                                      .setMessage("Invalid Username or Password")
                                                      .setCancelable(true)
                                                      .setPositiveButton(
                                                              "OK", (dialog, id) -> dialog.cancel())
                                                      .show(); }
}
    public void otherActivity(){
        Intent homeintent = new Intent(this, second.class);
        startActivity(homeintent);
    }@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}