package data;

import entity.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AccountDB {
    private static final AccountDB accountDB = new AccountDB();

    public static AccountDB getInstance() {
        return accountDB;
    }

    private final ArrayList<Account> accountList = new ArrayList<>();

    public void insertAccount(Account account) {
        accountList.add(account);
    }

    public void deleteAccount(Account account) {
        accountList.remove(account);
    }

    public ArrayList<Account> getAllAccount() {
        return accountList;
    }

    public List<Account> getAllAccountByUserID(String userID) {
        return accountList.stream().filter(x -> x.getUserID().equals(userID)).collect(Collectors.toList());
    }

    public Optional<Account> getAccountByAccountNumber(String userAccount) {
        return accountList.stream().filter(x -> x.getAccountNum().equals(userAccount)).findFirst();
    }
}