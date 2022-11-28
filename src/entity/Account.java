package entity;

public class Account {
    private int accountBalance;
    private String userID;
    private String accountNum;
    private String userName;

    public Account(){
        userID = "";
        accountNum = "";
        userName ="";

    }
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

/*
// 잔고보다 출금금액이 큰 경우에 대한 if는 앞단에서 잡아주시는게 예외처리에 대한 값을 잡지 않아도 되서 편할듯합니다.


이전 계좌 생성 로직 - static accountNum을 serial Num으로 두어 계속 +1 해주는 방식
    static private int accountNumCount = 1231212345;

//        String accountNumCountToString = Integer.toString(accountNumCount);
//        StringBuffer accountNumCountToStringBuffer = new StringBuffer(accountNumCountToString);
//        accountNumCountToStringBuffer.insert(2,"-").insert(4,"-");
//        String accountNum = accountNumCountToStringBuffer.toString();
//        accountNumCount++;
//        return accountNum;


 */