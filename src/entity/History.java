package entity;

import java.util.Date;

public class History {
    //거래 일자랑 시간을 date로 성형해서 찍기
    private Date tradeDate;
    private Date tradeTime;
    //AccountNum 키값
    private int accountNum;
    //입급 출급 여부 - 판별값 보내서 화인
    private int isTraded;
    //유저가 넣어준 금액
    private int money;
    //은행명 //받아서 쓰는걸로 할 거 같네요 - 고정할 것이냐 받아올 것이냐
    private String bankName;

    public History(int accountNum, int isTraded, int money, String bankName) {
        this.tradeDate = new Date("yyyy, MM, dd");
        this.tradeTime = new Date("hh : mm");
        this.accountNum = accountNum;
        this.isTraded = isTraded;
        this.money = money;
        this.bankName = bankName;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public Date getTradeTime() {
        return tradeTime;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public int getIsTraded() {
        return isTraded;
    }

    public int getMoney() {
        return money;
    }

    public String getBankName() {
        return bankName;
    }
}
