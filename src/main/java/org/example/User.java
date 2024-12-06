package org.example;

public class User {
    private final int id;
    private final String userName;

    // constructor
    public User(int id,String name){
        this.id = id;
        this.userName = name;
    }

    public int getId(){
        return id;
    }

    public String getUserName(){
        return userName;
    }
}
