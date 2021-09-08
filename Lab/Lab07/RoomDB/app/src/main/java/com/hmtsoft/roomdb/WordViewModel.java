package com.hmtsoft.roomdb;


import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.hmtsoft.roomdb.room.WordEntity;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;

    private LiveData<List<WordEntity>> mAllWords;

    public WordViewModel(Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    LiveData<List<WordEntity>> getAllWords() {
        return mAllWords;
    }

    public void insert(WordEntity word) {
        mRepository.insert(word);
    }

    public void deleteAll() {
        mRepository.deleteAll();
    }

    public void deleteWord(WordEntity word) {
        mRepository.deleteWord(word);
    }

    public void update(WordEntity word) {
        mRepository.update(word);
    }
}
