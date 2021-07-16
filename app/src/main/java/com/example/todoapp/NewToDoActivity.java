package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.todoapp.models.Note;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class NewToDoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_to_do);

        Button btnCancel = findViewById(R.id.btnDelete);
        Button btnCreateTask = findViewById(R.id.btnCreateTask);

        ImageView fistFile = findViewById(R.id.imgFirstfile);
        ImageView SecondFile = findViewById(R.id.imgSecondfile);

        TextInputEditText editTitle = findViewById(R.id.editTitle);
        TextInputEditText editDetail = findViewById(R.id.editDetails);
        TextInputEditText editSubtasks = findViewById(R.id.editSubtasks);

        Note newNote = new Note();





        btnCreateTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newNote.setTitle(editTitle.getText().toString());
                newNote.setDescription(editDetail.getText().toString());

                Toast.makeText(NewToDoActivity.this,newNote.getTitle() ,Toast.LENGTH_LONG).show();

                Snackbar.make(v,newNote.getDescription(), Snackbar.LENGTH_SHORT).show();


            }
        });


    }
}