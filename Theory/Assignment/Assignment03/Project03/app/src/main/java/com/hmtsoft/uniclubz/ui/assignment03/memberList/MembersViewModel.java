package com.hmtsoft.uniclubz.ui.assignment03.memberList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.hmtsoft.uniclubz.data.room.DatabaseRepository;
import com.hmtsoft.uniclubz.listener.DatabaseListener;
import com.hmtsoft.uniclubz.model.UserDetailsEntity;
import com.hmtsoft.uniclubz.utils.SingleLiveEvent;

import java.util.List;

public class MembersViewModel extends ViewModel {

    protected DatabaseRepository databaseRepository;
    protected LiveData<List<UserDetailsEntity>> userLiveList;
    protected SingleLiveEvent<String> databaseClearObserver = new SingleLiveEvent<>();

    public MembersViewModel() {
        databaseRepository = DatabaseRepository.getInstance();
        userLiveList = databaseRepository.getUserLiveList();
    }

    public void clearUserDatabase() {

        databaseRepository.clearAll(new DatabaseListener() {
            @Override
            public void onSuccess() {
                databaseClearObserver.postValue("User database cleared successfully");
            }

            @Override
            public void onFailed() {
                databaseClearObserver.postValue("User database couldn't be cleared");
            }
        });

    }


}
