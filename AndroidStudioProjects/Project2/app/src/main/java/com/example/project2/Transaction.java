package com.example.project2;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "transactionBank")
public class Transaction {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name="Username")
    private String Type;
    @ColumnInfo(name="Password")
    private String Data;

    public Transaction (String Type, String Data){
        this.Type = Type;
        this.Data = Data;
    }
    public String getData() {
        return Data;
    }
    public String getType() {
        return Type;
    }
    public void setData(String data) {
        Data = data;
    }
    public void setType(String type) {
        Type = type;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    @Override
    public String toString() {
        return Type + ": " + Data;
    }
}
