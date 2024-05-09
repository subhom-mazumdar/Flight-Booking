package com.example.flightbooking;

public class fetchers {
    String userid,name,password;
    fetchers()
    {

    }
    public fetchers(String userid, String name, String password) {
        this.userid = userid;
        this.name = name;
        this.password = password;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
