package com.example.project2;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "userBank")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name="Username")
    private String Username;
    @ColumnInfo(name="Password")
    private String Password;

    public User (String Username, String Password){
        this.Username = Username;
        this.Password = Password;
    }

    public int getId() {
        return id;
    }
    public String getUsername() {
        return Username;
    }
    public String getPassword() {
        return Password;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setFirstName(String Username) {
        this.Username = Username;
    }
    public void setNickname(String Password) {
        this.Password = Password;
    }

    @NonNull
    @Override
    public String toString() {
        return Username + " " + Password;
    }
}
