package com.example.geoquiz;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "userBank")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name="First Name")
    private String firstName;
    @ColumnInfo(name="Nickname")
    private String Nickname;
    @ColumnInfo(name="Last Name")
    private String lastName;
    @ColumnInfo(name="Correct")
    private int Correct;
    @ColumnInfo(name="Incorrect")
    private int Incorrect;

    public User (String firstName, String Nickname, String lastName, int Correct, int Incorrect){
        this.firstName = firstName;
        this.Nickname = Nickname;
        this.lastName = lastName;
        this.Correct = Correct;
        this.Incorrect = Incorrect;
    }

    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getNickname() {
        return Nickname;
    }
    public String getLastName() {
        return lastName;
    }
    public int getCorrect() {
        return Correct;
    }
    public int getIncorrect() {
        return Incorrect;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setNickname(String nickname) {
        Nickname = nickname;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setCorrect(int correct) {
        Correct = correct;
    }
    public void setIncorrect(int incorrect) {
        Incorrect = incorrect;
    }
    @NonNull
    @Override
    public String toString() {
        return firstName + " \"" + Nickname + "\" " + lastName + " [C" + Correct + ",I" + Incorrect + "]";
    }
}
