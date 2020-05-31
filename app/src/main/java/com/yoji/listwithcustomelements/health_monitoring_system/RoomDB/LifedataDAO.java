package com.yoji.listwithcustomelements.health_monitoring_system.RoomDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LifedataDAO {
    @Query("SELECT * FROM lifedata")
    LiveData<List<Lifedata>> getLifedata();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Lifedata lifedata);
}
