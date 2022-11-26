package entity;

public class Account {
    private static int accountNumCount = 1231212345;
    private int accountBalance;
    private String userID;
    private String accountNum;
    private String userName;

    public Account(String userID, String userName) {
        this.accountNum = makeAccountNum();
        this.accountBalance = 0;
        this.userName = userName;
        this.userID = userID;
    }

    private String makeAccountNum() {
        String accountNumCountToString = Integer.toString(accountNumCount);
        StringBuffer accountNumCountToStringBuffer = new StringBuffer(accountNumCountToString);
        accountNumCountToStringBuffer.insert(2, "-").insert(4, "-");
        String accountNum = accountNumCountToStringBuffer.toString();
        accountNumCount++;
        return accountNum;
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

    // 잔고보다 출금금액이 큰 경우에 대한 if는 앞단에서 잡아주시는게 예외처리에 대한 값을 잡지 않아도 되서 편할듯합니다.
    public void withdrawMoney(int money) {
        this.accountBalance -= money;
    }


}
