package com.example.geoquiz;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//@Database(entities = {Question.class}, version = 1, exportSchema = false)
@Database(entities = {Question.class, User.class}, version=2, exportSchema = false)
public abstract class TriviaDatabase extends RoomDatabase {


    public abstract QuestionDao question();
    public abstract UserDao user();
    private static TriviaDatabase sInstance;
    public static synchronized TriviaDatabase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                            TriviaDatabase.class, "trivia.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return sInstance;
    }

    public void populateInitialData() {
        runInTransaction(() -> {

            Question q1 = new Question("Monterey is the biggest city in California.",
                    false, "geography");

            question().addQuestion(q1);
            question().addQuestion(
                    new Question("James Dean filmed a movie in Spreckels.",
                            true, "film"));
            user().addUser(new User("Michael", "Mak", "Smith", 2, 0));
            user().addUser(new User("Chloe", "Clo", "Crane", 0, 2));
            user().addUser(new User("Frank", "Frankie", "Berger", 1, 1));

        });
    }

}
