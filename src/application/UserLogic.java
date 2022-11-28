package application;

import data.AccountDB;
import data.HistoryDB;
import data.UserDB;
import entity.Account;
import entity.History;
import entity.TradeType;
import entity.User;

import java.util.List;
import java.util.Optional;


public class UserLogic {

    UserDB userDB = UserDB.getInstance();
    AccountDB accountDB = AccountDB.getInstance();
    HistoryDB historyDB = HistoryDB.getInstance();

    private static UserLogic userLogic = new UserLogic();

    public static UserLogic getInstance() {
        return userLogic;
    }

    public String signUp(String name, String id, String pw) {
        Optional<User> opUser = userDB.getUserByUserId(id);
        if (opUser.isPresent()) {
            throw new IllegalArgumentException("아이디 중복");
        }
        User user = new User(id, pw, name, false);
        Account account = new Account(user.getUserID(), user.getUserName(), 0);
        History history = new History(account.getAccountNum(),account.getAccountBalance(), TradeType.생성, 0, "조미김");
        userDB.insertUser(user);
        accountDB.insertAccount(account);
        historyDB.insertHistory(history);
        return "정상적으로 회원가입 되었습니다!";
    }

    public User login(String id, String pw) {
        Optional<User> opUser = userDB.getUserByUserId(id);
        User user = opUser.orElseThrow(() -> new IllegalArgumentException("아이디 없음"));
        if (!user.getPassWord().equals(pw)) {
            throw new IllegalArgumentException("비밀번호 불일치");
        }
        return user;
    }


    public void makeAccount(User loginUser) {
        int countAc = accountDB.getAllAccountByUserID(loginUser.getUserID()).size();
        Account account = new Account(loginUser.getUserID(), loginUser.getUserName(), countAc);
        accountDB.insertAccount(account);
        History history = new History(account.getAccountNum(),account.getAccountBalance(), TradeType.생성, 0, "조미김 은행");
        historyDB.insertHistory(history);
    }

    public List<Account> getMyAccounts(User user) {
        List<Account> accounts = accountDB.getAllAccountByUserID(user.getUserID());
        return accounts;
    }

    public void depositMoney(int money, Account account) {
        account.depositMoney(money);
        History history = new History(account.getAccountNum(),account.getAccountBalance(), TradeType.입금, money, "조미김");
        historyDB.insertHistory(history);
    }

    public List<History> getAccountHistory(String accountNum) {
        return historyDB.getAllHistoryListByAccountNum(accountNum);
    }

    public boolean validateWithdrawAndDoLogic(Account account, int money) {
        if (account.getAccountBalance() - money < 0) {
            return false;
        }
        account.withdrawMoney(money);
        History history = new History(account.getAccountNum(),account.getAccountBalance(), TradeType.출금, money, "조미김");
        historyDB.insertHistory(history);
        return true;
    }
}