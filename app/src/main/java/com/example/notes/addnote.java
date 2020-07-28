package com.example.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addnote extends AppCompatActivity {
    String title,content;
    Button delete;
    int id;
    EditText edit_title,edit_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnote);
        Intent intent=getIntent();
        id=intent.getIntExtra("id",0);
        title=intent.getStringExtra("title");
        content=intent.getStringExtra("content");
        edit_content=findViewById(R.id.content);
        edit_title=findViewById(R.id.title);
        edit_title.setText(title);
        edit_content.setText(content);
        delete=findViewById(R.id.del);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.db.noteDao().delete(id);
                addnote.super.onBackPressed();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.sava,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.save){
            Note newnote=new Note(edit_title.getText().toString(),edit_content.getText().toString());
            newnote.id=id;
            MainActivity.db.noteDao().update(edit_title.getText().toString(),edit_content.getText().toString(),id);
            super.onBackPressed();

        }
        return true;
    }
}