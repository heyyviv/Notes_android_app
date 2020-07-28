package com.example.notes;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "NoteDatabase")
public class Note {
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "Title")
    String title;
    @ColumnInfo(name="Content")
    String content;

    public  Note(String title,String content){
        this.title=title;
        this.content=content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
