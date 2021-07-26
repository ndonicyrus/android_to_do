package com.example.todoapp;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ToDoDetailActivity extends AppCompatActivity {

    CollapsingToolbarLayout toolBarLayout;
    TextView txtDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

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
         if (getIntent().hasExtra("TITLE")) {
             toolBarLayout.setTitle(getIntent().getStringExtra("TITLE"));
         }
         if (getIntent().hasExtra("DETAILS")) {
             txtDetails.setText(getIntent().getStringExtra("DETAILS"));
         }
    }
}