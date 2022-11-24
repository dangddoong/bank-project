package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class History {
    //거래 일자랑 시간을 date로 성형해서 찍기
    private LocalDate tradeDate;
    private LocalTime tradeTime;
    //AccountNum 키값
    private String accountNum;
    //입급 출급 여부 - 판별값 보내서 화인
    private String isTraded;
    //유저가 넣어준 금액
    private String money;
    //은행명 //받아서 쓰는걸로 할 거 같네요 - 고정할 것이냐 받아올 것이냐
    private String bankName;

    //format으로 LocalDateTime 바꿔야 합니다.

    public History(String accountNum, String isTraded, String money, String bankName) {
        this.tradeDate = LocalDate.now();
        this.tradeTime = LocalTime.now();
        this.accountNum = accountNum;
        this.isTraded = isTraded;
        this.money = money;
        this.bankName = bankName;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public LocalTime getTradeTime() {
        return tradeTime;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public String getIsTraded() {
        return isTraded;
    }

    public String getMoney() {
        return money;
    }

    public String getBankName() {
        return bankName;
    }
}
