package entity;

import data.UserDB;

public class Account {
    private int accountNumCount = 1231212345;
    private int accountDeposit ;
    private String userID;
    private String accountNum;

    public Account(String userID) {
        this.accountNum = makeAccountNum();
        this.accountDeposit = 0;
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




}
