package entity;

public class User {
    private String userID;
    private String passWord;
    private String userName;
    private String accountNum;

    public User(String userID, String passWord, String name, String accountNum) {
        this.userID = userID;
        this.passWord = passWord;
        this.userName = name;
        this.accountNum = accountNum;
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
}

