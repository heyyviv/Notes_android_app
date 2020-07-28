package com.example.notes;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;

@Database( entities = {Note.class},version = 1,exportSchema = false)
public abstract class RoomDatabase extends androidx.room.RoomDatabase {
        public abstract  NoteDao noteDao();




}
