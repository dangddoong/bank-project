package entity;

public class Account {
    private int accountBalance;
    private String userID;
    private String accountNum;
    private String userName;

    public Account(String userID, String userName, int countAc) {
        this.accountNum = makeAccountNum(userID, countAc);
        this.accountBalance = 0;
        this.userName = userName;
        this.userID = userID;
    }

    private String makeAccountNum(String userID, int countAc) {
        String acNum = "73-8-";
        String tempString = "";

        for (int i = 0; i < userID.length(); i++) {
            int temp = userID.charAt(i) % 10;
            tempString += String.valueOf(temp);
            if(tempString.length() == 6) {
                break;
            }
        }

        Integer tempInt = Integer.valueOf(tempString);
        tempInt += (countAc * 17);
        acNum += tempInt;
        return acNum;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserID() {
        return userID;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void depositMoney(int money) {
        this.accountBalance += money;
    }

    public void withdrawMoney(int money) {
        this.accountBalance -= money;
    }
    public String toString(){
        return "계좌번호 : "+ accountNum + "이름 : " + userName+ "유저아이디 : " +userID+ "잔액 : " +accountBalance;
    }
}