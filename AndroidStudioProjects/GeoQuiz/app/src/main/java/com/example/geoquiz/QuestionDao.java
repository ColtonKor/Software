package com.example.geoquiz;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface QuestionDao {

    @Insert
    void addQuestion(Question question);

    @Query("SELECT COUNT(*) FROM questionBank")
    int count();

    @Query("SELECT * FROM questionBank")
    List<Question> getAll();

    @Delete
    void delete(Question question);


}
