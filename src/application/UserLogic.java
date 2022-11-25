package application;

import data.AccountDB;
import data.HistoryDB;
import data.UserDB;
import entity.Account;
import entity.History;
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
        if(opUser.isPresent()) {
            throw new IllegalArgumentException("아이디 중복");
        }
        User user = new User(id, pw, name, false);
        Account account = new Account(user.getUserID(), user.getUserName());
        History history = new History(account.getAccountNum(), TradeType.계좌생성, "0", "조미김");
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
        Account account = new Account(loginUser.getUserID(), loginUser.getUserName());
        History history = new History(account.getAccountNum(), TradeType.계좌생성, "0", "조미김 은행");
    }

    public List<Account> getMyAccounts(User user) {
        List<Account> accounts = accountDB.getAllAccountByUserName(user.getUserName());
        return accounts;
    }
}