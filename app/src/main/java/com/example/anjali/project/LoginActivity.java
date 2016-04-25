package com.example.anjali.project;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText uname,password;
    Button login;
    Boolean check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(" ");

        uname = ((EditText) findViewById(R.id.Email_text));
        password = ((EditText) findViewById(R.id.password_text));
        login = ((Button) findViewById(R.id.login_details));

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(uname.getText().toString().equals("admin") && password.getText().toString().equals("admin"))
                {
                    Intent i = new Intent(LoginActivity.this,AdminHome.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    DBHelper db = new DBHelper(getBaseContext());
                    db.open();
                    check = db.verifyUser(uname.getText().toString() , password.getText().toString());
                    db.close();
                    if (check){
                        Intent i2 = new Intent(LoginActivity.this,Drawer.class);
                        startActivity(i2);
                        finish();
                    }
                    else {
                        Toast.makeText(getBaseContext(),"Invalid Credentials. Please Login again or Register",Toast.LENGTH_SHORT).show();
                        Intent i1 = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(i1);
                        finish();
                    }

                }
            }
        });

    }
}
