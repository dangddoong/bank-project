package entity;

public class Account {
    private int accountNumCount = 1231212345;
    private int accountDeposit ;
    private String userID;
    private String accountNum;
    private String userName;

    public Account(String userID, String userName) {
        this.accountNum = makeAccountNum();
        this.accountDeposit = 0;
        this.userName = userName;
        this.userID = userID;
    }

    private String makeAccountNum() {
        String accountNumCountToString = Integer.toString(accountNumCount);
        StringBuffer accountNumCountToStringBuffer = new StringBuffer(accountNumCountToString);
        accountNumCountToStringBuffer.insert(3,"-").insert(5,"-");
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





}
