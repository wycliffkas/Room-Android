package com.room.roomandroid;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public void addUser(Users users);

    @Query("select * from users")
    public List<Users> getUsers();

}
