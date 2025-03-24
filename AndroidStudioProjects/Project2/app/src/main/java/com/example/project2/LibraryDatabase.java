package com.example.project2;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {Book.class, User.class, Transaction.class}, version=5, exportSchema = false)
public abstract class LibraryDatabase extends RoomDatabase {

    public abstract BookDao book();

    public abstract UserDao user();
    public abstract TransactionDao transaction();

    private static LibraryDatabase sInstance;

    public static synchronized LibraryDatabase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                            LibraryDatabase.class, "trivia.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return sInstance;
    }

    public void populateInitialData() {
        runInTransaction(() -> {
            book().addBook(new Book("A Heartbreaking work of Staggering Genius", "Dave Eggers", "Memoir"));
            book().addBook(new Book("The IDA Pro Book", "Chris Eagle", "Computer Science"));
            book().addBook(new Book("Frankenstein", "Mary Shelley", "Fiction"));
            user().addUser(new User("!admin2", "!admin2"));
            user().addUser(new User("hShuard", "m@thl3t3"));
            user().addUser(new User("bMishra", "bioN@no"));
            user().addUser(new User("shirleyBee", "Carmel2Chicago"));
        });
    }
}
