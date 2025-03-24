package com.example.geoquiz;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "questionBank")
public class Question {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "question")
    private String myQuestion;

    @ColumnInfo(name="answer")
    private boolean answer;

    @ColumnInfo(name="topic")
    private String topic;


    public Question(String myQuestion, boolean answer, String topic) {
        this.myQuestion = myQuestion;
        this.answer = answer;
        this.topic = topic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMyQuestion() {
        return myQuestion;
    }

    public void setMyQuestion(String myQuestion) {
        this.myQuestion = myQuestion;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @NonNull
    @Override
    public String toString() {
        return myQuestion + " -- " + answer;
    }
}
