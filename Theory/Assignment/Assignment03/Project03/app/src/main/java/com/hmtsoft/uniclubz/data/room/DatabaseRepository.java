package com.hmtsoft.uniclubz.data.room;

import androidx.lifecycle.LiveData;

import com.hmtsoft.uniclubz.App;
import com.hmtsoft.uniclubz.listener.DatabaseListener;
import com.hmtsoft.uniclubz.model.UserDetailsEntity;

import java.util.List;
import java.util.concurrent.Executors;

public class DatabaseRepository {

    private static DatabaseRepository instance;
    private UserListDao userListDao;

    public static DatabaseRepository getInstance() {
        if (instance == null) {
            instance = new DatabaseRepository();
        }
        return instance;
    }

    private DatabaseRepository() {
        userListDao = UserDatabase.getInstance(App.getContext()).userListDao();
    }

    public void insertUser(UserDetailsEntity entity, DatabaseListener listener) {
        Executors.newSingleThreadExecutor().execute(() -> {
            long id = userListDao.insert(entity);
            if (id > 0)
                listener.onSuccess();
            else
                listener.onFailed();
        });
    }

    public void clearAll(DatabaseListener listener) {
        Executors.newSingleThreadExecutor().execute(() -> {
            int id = userListDao.deleteAll();
            if (id > 0)
                listener.onSuccess();
            else
                listener.onFailed();
        });
    }

    public LiveData<List<UserDetailsEntity>> getUserLiveList() {
        return userListDao.getLiveList();
    }

}
