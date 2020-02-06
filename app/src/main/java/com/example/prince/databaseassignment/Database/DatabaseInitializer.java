package com.example.prince.databaseassignment.Database;

import android.os.AsyncTask;

import com.example.prince.databaseassignment.Database.AppDatabase;

public class DatabaseInitializer {

    public static void populateAsync(final AppDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateAsync(mDb);
            return null;
        }
    }

}
