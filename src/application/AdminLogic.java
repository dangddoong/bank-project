package application;

import data.AccountDB;
import data.HistoryDB;
import data.UserDB;
import entity.Account;
import entity.History;
import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class AdminLogic {
    UserDB userDB = UserDB.getInstance();
    AccountDB accountDB = AccountDB.getInstance();
    HistoryDB historyDB = HistoryDB.getInstance();

    private static final AdminLogic adminLogic = new AdminLogic();

    public static AdminLogic getInstance() {
        return adminLogic;
    }

    public void signUp(String name, String id, String pw) {
        Optional<User> opUser = userDB.getUserByUserId(id);
        if (opUser.isPresent()) {
            throw new IllegalArgumentException("아이디 중복");
        }
        User user = new User(id, pw, name, true);
        userDB.insertUser(user);
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

    public void changeUserPw(String id, String pw) {
        Optional<User> user = confirmId(id);
        if (user.isEmpty()) {
            throw new IllegalArgumentException("아이디 없음");
        }
        User foundUser = user.get();
        foundUser.changeUserPassword(pw);
    }

    public List<Account> getUserAccounts(String id) {
        Optional<User> user = confirmId(id);
        List<Account> accounts = accountDB.getAllAccount().stream().filter(i -> i.getUserID().equals(id)).collect(Collectors.toList());
        if (accounts.isEmpty()) {
            throw new IllegalArgumentException("계좌가 없습니다");
        }
        return accounts;
    }

    public List<Account> getUserAccountsByID(String userID) {
        List<Account> accounts = accountDB.getAllAccountByUserID(userID);
        if (accounts.isEmpty()) {
            throw new IllegalArgumentException("해당 유저의 계좌가 없습니다");
        }
        return accounts;
    }

    public void deleteAccount(Account account) {
        accountDB.deleteAccount(account);
        historyDB.deleteHistoriesByAccountNumber(account.getAccountNum());
    }

    public Account findAccountsByAccountNum(String userAccountNum) {
        Optional<Account> OpAccount = accountDB.getAccountByAccountNumber(userAccountNum);
        if (OpAccount.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 계좌");
        }
        return OpAccount.get();
    }

    public ArrayList<Account> getAllAccounts() {
        return accountDB.getAllAccount();
    }

    public ArrayList<History> getAllHistories() {
        return historyDB.getAllHistory();
    }

    public List<User> getAllUsers() {
        return userDB.getAllUsers();

    }
}
/*
    Optional<Account> first = accountDB.getAllAccount().stream().filter(account -> account.getAccountNum().equals(userAccount)).findFirst();
    Account account = first.get();
    String userId = account.getUserID();
    Optional<User> opUser = userDB.getUserByUserId(userId);
    User user = opUser.get();
        return user;
*/
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