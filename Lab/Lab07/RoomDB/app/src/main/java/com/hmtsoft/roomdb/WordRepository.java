package com.hmtsoft.roomdb;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.hmtsoft.roomdb.room.WordDao;
import com.hmtsoft.roomdb.room.WordEntity;
import com.hmtsoft.roomdb.room.WordRoomDatabase;

import java.util.List;

public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<WordEntity>> mAllWords;

    WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    LiveData<List<WordEntity>> getAllWords() {
        return mAllWords;
    }

    public void insert(WordEntity WordEntity) {
        new insertAsyncTask(mWordDao).execute(WordEntity);
    }

    public void update(WordEntity WordEntity)  {
        new updateWordAsyncTask(mWordDao).execute(WordEntity);
    }

    public void deleteAll()  {
        new deleteAllWordsAsyncTask(mWordDao).execute();
    }

    // Must run off main thread
    public void deleteWord(WordEntity WordEntity) {
        new deleteWordAsyncTask(mWordDao).execute(WordEntity);
    }

    // Static inner classes below here to run database interactions in the background.

    /**
     * Inserts a WordEntity into the database.
     */
    private static class insertAsyncTask extends AsyncTask<WordEntity, Void, Void> {

        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final WordEntity... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    /**
     * Deletes all words from the database (does not delete the table).
     */
    private static class deleteAllWordsAsyncTask extends AsyncTask<Void, Void, Void> {
        private WordDao mAsyncTaskDao;

        deleteAllWordsAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }

    /**
     *  Deletes a single WordEntity from the database.
     */
    private static class deleteWordAsyncTask extends AsyncTask<WordEntity, Void, Void> {
        private WordDao mAsyncTaskDao;

        deleteWordAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final WordEntity... params) {
            mAsyncTaskDao.deleteWord(params[0]);
            return null;
        }
    }

    /**
     *  Updates a WordEntity in the database.
     */
    private static class updateWordAsyncTask extends AsyncTask<WordEntity, Void, Void> {
        private WordDao mAsyncTaskDao;

        updateWordAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final WordEntity... params) {
            mAsyncTaskDao.update(params[0]);
            return null;
        }
    }
}
