package com.yoji.listwithcustomelements.health_monitoring_system.RoomDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDataDAO {

    @Query("SELECT * FROM user_data")
    LiveData<List<UserData>> getUsersData();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(UserData userData);
}
