package com.donation.app;

public class UserSingleton {

    private static UserSingleton single_instance = null;

    // variable of type String
    private String user;

    // private constructor restricted to this class itself
    private UserSingleton()
    {
    }

    // static method to create instance of Singleton class
    public static UserSingleton getInstance()
    {
        if (single_instance == null)
            single_instance = new UserSingleton();

        return single_instance;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return this.user;
    }

}
