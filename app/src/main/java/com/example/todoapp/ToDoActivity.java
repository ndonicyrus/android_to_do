package com.example.todoapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.todoapp.models.Note;
import com.example.todoapp.settings.SharedPrefConfig;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.navigation.ui.AppBarConfiguration;

import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import io.objectbox.Box;

public class ToDoActivity extends AppCompatActivity {

    TextView welcomeText;
    private Box<Note> notesBox;

    int numberOfSearches = 0;
    private AppBarConfiguration appBarConfiguration;
    private Object Intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        notesBox = ObjectBox.get().boxFor(Note.class);

        Toast.makeText(this,"You have" + notesBox.count()+ "To dos.",Toast.LENGTH_SHORT).show();

        setContentView(R.layout.activity_to_do);


        welcomeText = findViewById(R.id.welcometext);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        CardView singleCard = findViewById(R.id.card_single);
        singleCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ToDoActivity.this, ToDoDetailActivity.class);
                startActivity(intent);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ToDoActivity.this, NewToDoActivity.class);
                startActivity(intent);
            }
        });
    }

    public int addNumber()
    {

        return numberOfSearches++;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_to_do_detail, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       int menu_id = item.getItemId();

       if (menu_id == R.id.action_logout){

           SharedPrefConfig sharedPrefConfig = new SharedPrefConfig(this);
           sharedPrefConfig.setLoggingInStatus(false);

           Intent intent = new Intent(ToDoActivity.this, MainActivity.class);
           startActivity(intent);
            return true;

       }
       else if (menu_id == R.id.action_settings){
           Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show();
       }
       else {
       }   return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        if (getIntent().hasExtra("username"));
        welcomeText.setText(getIntent().getStringExtra("username"));
        super.onResume();
    }
}