package data;

import entity.History;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// 거래 내역은 거래 일자, 거래 시간, 계좌번호, 입금/출금 여부, 거래 금액, 은행 명으로 구성된다.
public class HistoryDB {

    private static HistoryDB historyDB = new HistoryDB();

    public static HistoryDB getInstance() {
        return historyDB;
    }

    private ArrayList<History> histories = new ArrayList<>();

    public ArrayList<History> getAllHistory(){
        return histories;
    }

    //Account를 받으면 / History를 뱉어주는? / history
    public void insertHistory(History history){
        histories.add(history);
    }

    public Optional<History> getHistory(String accountNum) {
        for (History history : histories) {
            if (history.getAccountNum().equals(accountNum)) {
                return Optional.of(history);
            }
        }
        return Optional.empty();
    }

    public void deleteHistoriesByAccountNumber(String accountNum) {
        histories.stream()
                .filter(a -> a.getAccountNum().equals(accountNum))
                .collect(Collectors.toList())
                .forEach(h->{ histories.remove(h); } );
    }
    public List<History> getAllHistoryListByAccountNum(String accountNum) {
        List<History> historyList = histories.stream().filter(x -> x.getAccountNum().equals(accountNum)).collect(Collectors.toList());
        return historyList;
    }

    public List<History> getAccountHistory(String accountNum){
        return historyDB.getAllHistoryListByAccountNum(accountNum);
    }
}


