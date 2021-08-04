package com.example.todoapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.todoapp.models.Note;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import io.objectbox.Box;

public class ToDoDetailActivity extends AppCompatActivity {

    CollapsingToolbarLayout toolBarLayout;
    TextView txtDetails;
    private Box<Note> notesBox;
    long idToUse = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());
        notesBox = ObjectBox.get().boxFor(Note.class);

        TextView todotime = findViewById(R.id.todotime);
        TextView tododate = findViewById(R.id.tododate);
        txtDetails = findViewById(R.id.txtDetails);

//        RecyclerView subtasksrecyclerview = findViewById(R.id.subtaskrecyclerview);
//        RecyclerView filerecyclerview = findViewById(R.id.filerecyclerview);

        Button btnDelete = findViewById(R.id.btnDelete);

        Button btnComplete =findViewById(R.id.btnComplete);



        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(v, "Task Added Successfully", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(ToDoDetailActivity.this, ToDoActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnDelete.setOnClickListener(v ->{
            //TODO:Add alert to ask user if he/she really wants to delete this

            if (idToUse == 0){
                Toast.makeText(this, "No Todo selected", Toast.LENGTH_SHORT).show();
            }
            else{
                notesBox.remove(idToUse);
                Snackbar.make(v,"Todo deleted successfully", Snackbar.LENGTH_SHORT).show();
                Intent intent = new Intent(this, ToDoActivity.class);
                startActivity(intent);
                finish();

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

    @Override
    protected void onResume() {
        super.onResume();
         if (getIntent().hasExtra("ID")) {


             idToUse = getIntent().getLongExtra("ID", 0);
             Note savedNote = notesBox.get(idToUse);

             toolBarLayout.setTitle(savedNote.getTitle());
             txtDetails.setText(savedNote.getDescription());
         }

    }
}