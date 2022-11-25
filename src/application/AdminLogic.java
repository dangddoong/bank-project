package application;
import data.UserDB;
import data.AccountDB;
import data.HistoryDB;
import entity.History;
import entity.User;
import entity.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class AdminLogic {
    UserDB userDB = UserDB.getInstance();
    AccountDB accountDB = AccountDB.getInstance();
    HistoryDB historyDB = HistoryDB.getInstance();

    private static AdminLogic adminLogic = new AdminLogic();

    public static AdminLogic getInstance() {
        return adminLogic;
    }

    public String signUp(String name, String id, String pw) {
        Optional<User> opUser = userDB.getUserByUserId(id);
        if (opUser.isPresent()) {
            throw new IllegalArgumentException("아이디 중복");
        }
        User user = new User(id, pw, name, true);
        userDB.insertUser(user);
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

    public Optional<User> confirmId(String id) {
        Optional<User> opUser = userDB.getUserByUserId(id);
        if (opUser.isEmpty()) {
            throw new IllegalArgumentException("아이디 없음");
        }
        return opUser;
    }

    public String changeUserPw(String id, String pw) {
        Optional<User> user = confirmId(id);
        User foundUser = user.get();
        foundUser.changeUserPassword(pw);
        String message = "비밀번호 변경 완료";
        return message;
    }

    public List<Account> getUserAccounts(String id) {
        Optional<User> user = confirmId(id);
        List<Account> accounts = accountDB.getAllAccount()
                .stream()
                .filter(i -> i.getUserID().equals(id))
                .collect(Collectors.toList());
        return accounts;
    }

    public void deleteAccount(Account account) {
        accountDB.deleteAccount(account);
        historyDB.deleteHistoriesByAccountNumber(account.getAccountNum());
    }

    public User findUserByAccount(String userAccount){
        Optional<Account> first = accountDB.getAllAccount().stream().filter(account -> account.getAccountNum().equals(userAccount)).findFirst();
        Account account = first.get();
        String userId = account.getUserID();
        Optional<User> opUser = userDB.getUserByUserId(userId);
        User user = opUser.get();
        return user;
    }

    public ArrayList<Account> getAllAcounts() {
        ArrayList<Account> allAccounts = accountDB.getAllAccount();
        return allAccounts;
    }

    public ArrayList<History> getAllHistories() {
        ArrayList<History> histories = historyDB.getAllHistory();
        return histories;
    }
}

   /* public Optional<Account> confirmAccount(String userAccount){
        AccountDB accountDB = new AccountDB();
        for (Account account : accountDB) {
            if (account.getAccountNum().equals(userAccount)) {
                return account;
            }
        }
        return Optional.empty();
    }
    필요없어서 뺌 원래는 계좌번호 받아서 Account 출력하던 로직
    */