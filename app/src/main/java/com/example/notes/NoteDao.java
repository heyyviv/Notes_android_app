package com.example.notes;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {

    @Query("INSERT INTO NoteDatabase (Title,Content) VALUES (:title,:content)")
    public void insert(String title,String content);
    @Query("SELECT * FROM NoteDatabase ")
    public List<Note>  getall();

    @Query("UPDATE NoteDatabase SET Content = :content ,Title=:title WHERE id = :id")
    public void update(String title,String content,int id);

    @Query("DELETE FROM NoteDatabase WHERE id=:id")
    public void delete(int id);
}
