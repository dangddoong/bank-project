package entity;

import data.UserDB;

public class User {
    private String userID;
    private String passWord;
    private String userName;
    private String accountNum;
    private boolean isAdmin = false;


    public User(String userID, String passWord, String name) {
        this.userID = userID;
        this.passWord = passWord;
        this.userName = name;
        this.accountNum = makeAccountNum();
        if (isAdmin){
            this.accountNum = null;
        }
    }

    public void makeAccountAdmin(boolean admin) {
        isAdmin = admin;
    }


    public String getUserID() {
        return userID;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getName() {
        return userName;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public void changeByAdmin(String pw) {
        this.passWord = pw;
    }
}

