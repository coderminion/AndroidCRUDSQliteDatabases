package com.coderminion.androidsqlitedatabases.model;

/**
 * Created by phoenix on 6/8/17.
 */

public class User {

    int id;
    String name;


    public  User()
    {

    }
    public User(int id,String name)
    {
        this.id =id;
        this.name =name;
    }
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
