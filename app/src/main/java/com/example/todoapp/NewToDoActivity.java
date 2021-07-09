package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.text.BreakIterator;

public class NewToDoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_to_do);

        Button btnCancel = findViewById(R.id.btnCancel);
        Button btnCreateTask = findViewById(R.id.btnCreateTask);

        ImageView fistFile = findViewById(R.id.imgFirstfile);
        ImageView SecondFile = findViewById(R.id.imgSecondfile);

        TextInputEditText editTitle = findViewById(R.id.editTitle);
        TextInputEditText editDetail = findViewById(R.id.editDetails);
        TextInputEditText editSubtasks = findViewById(R.id.editSubtasks);


        btnCreateTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTitle.getText().toString();
                String detail = editDetail.getText().toString();

                Toast.makeText(NewToDoActivity.this,title ,Toast.LENGTH_LONG).show();

                Snackbar.make(v,detail, Snackbar.LENGTH_SHORT).show();


            }
        });


    }
}