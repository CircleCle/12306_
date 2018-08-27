package com.example.yuanmao.a12306_;

import org.litepal.crud.DataSupport;

public class SaveCount extends DataSupport {
    private String userName;
    private String password;
    private Boolean isRemember;
    private Boolean isAutoLogin;

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

    public void setAutoLogin(Boolean autoLogin) {
         this.isAutoLogin = autoLogin;
    }

    public Boolean getAutoLogin() {
        return isAutoLogin;
    }

    public void setRemember(Boolean remember) {
        this.isRemember = remember;
    }

    public Boolean getRemember() {
        return isRemember;
    }
}
