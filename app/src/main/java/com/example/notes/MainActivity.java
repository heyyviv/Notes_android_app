package com.example.notes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Observable;

public class MainActivity extends AppCompatActivity {
    public static RoomDatabase db;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    NoteAdapter adapter;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         db = Room.databaseBuilder(getApplicationContext(),
                RoomDatabase.class, "NoteDatabase").allowMainThreadQueries()
                 .build();
         recyclerView=findViewById(R.id.recycle);
         layoutManager=new LinearLayoutManager(this);
         adapter=new NoteAdapter();
         recyclerView.setLayoutManager(layoutManager);
         recyclerView.setAdapter(adapter);
        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.noteDao().insert("title","content");
                adapter.reload();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.reload();
    }
}