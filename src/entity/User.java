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

    public void ChangeUserPassword(String pw) {
        this.passWord = pw;
    }
}



/*
    public void makeAccountAdmin(boolean admin) {
        isAdmin = admin;
    }

    private String makeAccountNum() {
        int randomCount = (int) (Math.random()*100000000);
        String test = Integer.toString(randomCount);
        StringBuffer a = new StringBuffer(test);
        a.insert(2,"-").insert(6,"-");
        String accountNum = a.toString();

        UserDB userDB = new UserDB();

        for (User user : userDB.getAllUser()) {
            if (!user.getAccountNum().equals(accountNum)) {
                makeAccountNum();
            }
        }
        return accountNum;
    }
 */