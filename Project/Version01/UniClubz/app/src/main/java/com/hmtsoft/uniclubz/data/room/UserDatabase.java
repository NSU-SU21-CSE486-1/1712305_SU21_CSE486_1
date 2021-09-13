package com.hmtsoft.uniclubz.data.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.hmtsoft.uniclubz.data.room.converters.PhoneNumberConverter;
import com.hmtsoft.uniclubz.data.room.converters.UniversityConverter;
import com.hmtsoft.uniclubz.model.UserDetailsEntity;

@TypeConverters({UniversityConverter.class, PhoneNumberConverter.class})
@Database(entities = {UserDetailsEntity.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    private static UserDatabase instance;

    public abstract UserListDao userListDao();

    public static synchronized UserDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "user_list.db")
                    .build();
        }
        return instance;

    }
}
