package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.todoapp.models.Note;
import com.example.todoapp.models.Subtask;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import io.objectbox.Box;

public class NewToDoActivity extends AppCompatActivity
{
    TextInputEditText editTitle;
    private Box<Note>notesBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new_to_do);

        notesBox = ObjectBox.get().boxFor(Note.class);

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

                notesBox.put(newNote); //Creates an new note in the database

                Intent intent = new Intent(NewToDoActivity.this, ToDoDetailActivity.class);
                intent.putExtra("TITLE", newNote.getTitle());
                intent.putExtra("DETAILS", newNote.getDescription());

                startActivity(intent);
            }


        });

    }
    @Override
    protected void onStop() {
        super.onStop();
//        if (editTitle.getText().toString().trim().isEmpty()) {
//            Toast.makeText(this, "Draft Not Saved", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "Draft Saved", Toast.LENGTH_SHORT).show();
//
//        }
    }
}