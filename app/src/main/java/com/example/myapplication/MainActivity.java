package com.example.myapplication;
//Code below is based on Android SQLite Tutorial | Android CRUD Tutorial with SQLite (Create, Read, Update, Delete), ProgrammingKnowledge, https://www.youtube.com/watch?v=kDZES1wtKUY
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity{

    DatabaseHelper myDb;
    EditText editName, editSurname, editMarks;
    Button btnAddData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        editName = (EditText)findViewById(R.id.editText_name);
        editSurname = (EditText)findViewById(R.id.editText_surname);
        editMarks = (EditText)findViewById(R.id.editText_Marks);
        btnAddData = (Button)findViewById(R.id.button_add);
        AddData();

    }


    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editName.getText().toString(),
                                editSurname.getText().toString(),
                                editMarks.getText().toString() );
                        if (isInserted = true)
                            Toast.makeText(MainActivity.this,"Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}
//END
