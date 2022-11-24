package entity;

public class User {
    private String userID;
    private String passWord;
    private String userName;
    private String accountNum;

    public User(String userID, String passWord, String name) {
        this.userID = userID;
        this.passWord = passWord;
        this.userName = name;
        this.accountNum = makeAccountNum();
    }

    private String makeAccountNum() {
        // TODO: 2022/11/24  - 로직 짜주세요
        return "(^[0-9]+)$";
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

