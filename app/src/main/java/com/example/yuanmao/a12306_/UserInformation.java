package com.example.yuanmao.a12306_;

import org.litepal.crud.DataSupport;

public class UserInformation extends DataSupport{
    private String userName;
    private String password;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

}
