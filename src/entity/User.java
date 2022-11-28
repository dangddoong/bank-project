package entity;

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

    public User() {
        userID = "";
        passWord = "";
        userName = "";
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
        this.passWord = pw;
    }

    public String toString(){
        return "계좌의 소유자명 : "+ userID +" 소유자의 아이디 : "+ userName;
    }
}


