package com.example.projectpertanusa;

public class UserModel {
    //             paramKey,
    private String userNIK, userName;

    public UserModel(String userNIK, String userName) {
        this.userNIK = userNIK;
        this.userName = userName;
    }

    public String getUserNIK() {
        return userNIK;
    }

    public String getUserName() {
        return userName;
    }
}
