package entity;

import data.UserDB;

public class User {
    private String userID;
    private String passWord;
    private String userName;
    private boolean isAdmin;
    
    public User(String userID, String passWord, String name, boolean isAdmin) {
        this.userID = userID;
        this.passWord = passWord;
        this.userName = name;
        this.isAdmin = isAdmin;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void changeUserPassword(String pw) {
        passWord = pw;
    }

    public String toString(){
        return "유저 아이디 : " + userID + "이름 : " + userName;
    }
}


