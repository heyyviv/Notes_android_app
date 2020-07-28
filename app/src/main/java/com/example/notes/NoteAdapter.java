package com.example.notes;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewholder> {
    public class  NoteViewholder extends RecyclerView.ViewHolder{
        LinearLayout container;
        TextView title,content;
        int id;
        public NoteViewholder(@NonNull View itemView) {
            super(itemView);
            this.container=itemView.findViewById(R.id.container);
            this.title=itemView.findViewById(R.id.title);
            this.content=itemView.findViewById(R.id.content);

            container.setOnClickListener(v -> {
                Context context=v.getContext();

                Log.v("notes",title.getText().toString());
                Log.v("notes",content.getText().toString());
                Log.v("notes",Integer.toString(id));
                Intent intent=new Intent(v.getContext(),addnote.class);
                intent.putExtra("title",title.getText().toString());
                intent.putExtra("content",content.getText().toString());
                intent.putExtra("id",id);

                context.startActivity(intent);
            });
        }
    }
    List<Note> mnote;
    String colors[]={"#ADD8E6","#00FF00","#FFA500","#C0C0C0"};

    @NonNull
    @Override
    public NoteAdapter.NoteViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.noteadapter,parent,false);
        return new NoteViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.NoteViewholder holder, int position) {
            Note current=mnote.get(position);
            holder.container.setBackgroundColor(Color.parseColor(colors[position%4]));
            holder.title.setText(current.getTitle());
            holder.content.setText(current.getContent());
            holder.id=current.id;

    }

    @Override
    public int getItemCount() {
        return mnote.size();
    }
    public  void reload(){
        mnote=MainActivity.db.noteDao().getall();
        notifyDataSetChanged();
    }
}
