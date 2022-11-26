package entity;

import src.entity.TradeType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class History {
    //거래 일자랑 시간을 date로 성형해서 찍기
    private String tradeDate;
    //AccountNum 키값
    private String accountNum;
    //입급 출급 여부 - 판별값 보내서 화인
    private TradeType tradeType;
    //유저가 넣어준 금액
    private String money;
    //은행명 //받아서 쓰는걸로 할 거 같네요 - 고정할 것이냐 받아올 것이냐
    private String bankName;

    //format으로 LocalDateTime 바꿔야 합니다.

    public History(String accountNum, TradeType tradeType, String money, String bankName) {
        this.tradeDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.accountNum = accountNum;
        this.tradeType = tradeType;
        this.money = money;
        this.bankName = bankName;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public TradeType getTradeType() {
        return tradeType;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public String getHistoryAccount(){ return accountNum; }


    public String getMoney() {
        return money;
    }

    public String getBankName() {
        return bankName;
    }

    public String toString(){
        return "거래 일자 : " + tradeDate.split("T")[0] +   "거래 시간 : " + tradeDate.split("T")[1] + tradeType + " : " + money + "잔액 : "+ "필드 필요" + "은행명 : " + bankName;
    }
}
