package data;

import entity.History;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HistoryDB {
    private static final HistoryDB historyDB = new HistoryDB();

    public static HistoryDB getInstance() {
        return historyDB;
    }

    private final ArrayList<History> histories = new ArrayList<>();

    public ArrayList<History> getAllHistory() {
        return histories;
    }

    public void insertHistory(History history) {
        histories.add(history);
    }

    public void deleteHistoriesByAccountNumber(String accountNum) {
        histories.stream().filter(a -> a.getAccountNum().equals(accountNum)).toList().forEach(histories::remove);
    }

    public List<History> getAllHistoryListByAccountNum(String accountNum) {
        return histories.stream().filter(x -> x.getAccountNum().equals(accountNum)).collect(Collectors.toList());
    }
}

// MEMO - 거래 내역은 거래 일자, 거래 시간, 계좌번호, 입금/출금 여부, 거래 금액, 은행 명으로 구성된다.
// MEMO - Account를 받으면 / History를 뱉어주는? / history

/*
// 저희 로직중에는 history 하나를 단건 조회하는게 없어서 빼두었습니다.
    public Optional<History> getHistory(String accountNum) {
        for (History history : histories) {
            if (history.getAccountNum().equals(accountNum)) {
                return Optional.of(history);
            }
        }
        return Optional.empty();
    }

// getAccountHistory() 메서드 자체가 getAllHistoryListByAccountNum()을 불러서 로직을 그대로 수행하기때문에,
// a() 로직이 똑같이 b() 로직을 불러서 b() 로직의 리턴값을 그대로 뱉어낸다면, 그냥 b()로직 하나만 두고 그것만 쓰면 됩니다.
// 따라서, a() 로직을 주석처리 하겠습니다.
    public List<History> getAccountHistory(String accountNum){
        return historyDB.getAllHistoryListByAccountNum(accountNum);
    }

 */