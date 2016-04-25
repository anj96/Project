package com.example.anjali.project;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    Button submitButton;
    EditText nameText,emailText,passwordText,professionText;
    TextView enterName,enterEmail, enterPassword, enterProfession;
    TextView databaseValue;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nameText = (EditText)findViewById(R.id.nameText);
        professionText = (EditText)findViewById(R.id.emailText);
        emailText = (EditText)findViewById(R.id.emailText);
        passwordText = (EditText)findViewById(R.id.passwordText);
        enterName = (TextView)findViewById(R.id.enterName);
        enterEmail = (TextView)findViewById(R.id.enterEmail);
        enterPassword = (TextView)findViewById(R.id.enterPassword);
        enterProfession = (TextView)findViewById(R.id.enterPassword);
        databaseValue = (TextView)findViewById(R.id.databaseValue);
        dbHelper= new DBHelper(getBaseContext());
       // printDatabase();


        submitButton= (Button)findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                dbHelper.insertEntry(nameText.getText().toString(),emailText.getText().toString(),passwordText.getText().toString(),professionText.getText().toString());
                printDatabase();
               // Intent i = new Intent(RegisterActivity.this, Registered.class);
                //startActivity(i);

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void printDatabase(){
        String dbString =dbHelper.getEntry();
        databaseValue.setText(dbString);
        nameText.setText("");

    }

}
