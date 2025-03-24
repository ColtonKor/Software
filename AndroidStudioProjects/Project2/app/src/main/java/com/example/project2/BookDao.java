package com.example.project2;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookDao {
    @Insert
    void addBook(Book book);

    @Query("SELECT COUNT(*) FROM bookDatabase")
    int count();

    @Query("SELECT * FROM bookDatabase")
    List<Book> getAll();

    @Delete
    void delete(Book book);
}
