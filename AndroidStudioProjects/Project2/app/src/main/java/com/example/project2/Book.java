package com.example.project2;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bookDatabase")
public class Book {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name="Book Title")
    private String Title;
    @ColumnInfo(name="Author")
    private String Author;
    @ColumnInfo(name="Genre")
    private String Genre;


    public Book (String Title, String Author, String Genre){
        this.Title = Title;
        this.Author = Author;
        this.Genre = Genre;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return Title;
    }
    public String getAuthor() {
        return Author;
    }
    public String getGenre() {
        return Genre;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String Title) {
        this.Title = Title;
    }
    public void setAuthor(String Author) {
        this.Author = Author;
    }
    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    @NonNull
    @Override
    public String toString() {
        return Title + " by " + Author + " \"" + Genre + "\"";
    }
}
