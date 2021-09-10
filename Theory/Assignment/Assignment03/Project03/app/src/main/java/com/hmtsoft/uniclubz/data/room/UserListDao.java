package com.hmtsoft.uniclubz.data.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.hmtsoft.uniclubz.model.UserDetailsEntity;

import java.util.List;

@Dao
public interface UserListDao {

    @Query("SELECT * FROM user_list_table")
    LiveData<List<UserDetailsEntity>> getLiveList();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(UserDetailsEntity entity);

    @Delete
    void delete(UserDetailsEntity entity);

    @Query("DELETE FROM user_list_table")
    int deleteAll();

}
