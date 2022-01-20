package com.messenger;

import java.util.UUID;

public class User {
    private UUID userUUID;
    private String userName;
    private String userInfo;
    private String userLogin;
    private String userPassword;

    public User( UUID userUUID, String userName, String userInfo, String userLogin, String userPassword){
        this.userUUID = userUUID;
        this.userName = userName;
        this.userInfo = userInfo;
        this.userLogin = userLogin;
        this.userPassword = userPassword;

    }

    public UUID getUserUUID() {
        return userUUID;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserUUID(UUID userUUID) {
        this.userUUID = userUUID;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userUUID +
                ", userName='" + userName + '\'' +
                ", userInfo='" + userInfo + '\'' +
                ", userLogin='" + userLogin + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
