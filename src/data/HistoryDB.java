package data;

import entity.History;

import java.util.ArrayList;
import java.util.Optional;

// 거래 내역은 거래 일자, 거래 시간, 계좌번호, 입금/출금 여부, 거래 금액, 은행 명으로 구성된다.
public class HistoryDB {
    ArrayList<History> histories = new ArrayList<>();

    public ArrayList<History> getAllHistory(){
        return histories;
    }

    //Account를 받으면 / History를 뱉어주는? / history
    public Optional<History> getHistory(String account){
        for (History history : histories) {
            if(history.getAccountNum().equals(account)){
                return Optional.of(history);
            }
        }
        return Optional.empty();
    }

}
