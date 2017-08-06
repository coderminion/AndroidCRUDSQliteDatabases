package com.coderminion.androidsqlitedatabases.sqliteutils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;
import java.util.Map;

import com.coderminion.androidsqlitedatabases.model.User;

/**
 * Created by phoenix on 6/8/17.
 */


public class SqliteHelper extends SQLiteOpenHelper {
    UserOperations userOperations;

    public SqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        userOperations = new UserOperations(this);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        userOperations.onCreate(sqLiteDatabase);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        userOperations.onUpgrade(sqLiteDatabase,i,i1);
    }

    public void add(User user)
    {
        userOperations.add(user);
    }

    // Getting single
    public User get(int id) {
        return userOperations.get(id);
    }

    // Getting All
    public List<User> getAll() {
        return userOperations.getAll();
    }

    public List<Map> getAllByMap() {
        return userOperations.getAllByMap();
    }

    // Updating single
    public int update(User user) {
        return userOperations.update(user);
    }

    // Deleting single
    public void delete(User user) {
        userOperations.delete(user);
    }

    public void deleteAll() {
        userOperations.deleteAll();
    }

    // Getting Count
    public int getCount() {
        return userOperations.getCount();
    }
}