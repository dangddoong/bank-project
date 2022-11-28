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
        histories.stream().filter(a -> a.getAccountNum().equals(accountNum)).toList().forEach(h -> histories.remove(h));
    }

    public List<History> getAllHistoryListByAccountNum(String accountNum) {
        return histories.stream().filter(x -> x.getAccountNum().equals(accountNum)).collect(Collectors.toList());
    }
}