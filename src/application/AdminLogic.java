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
        User user = userDB.getUserByUserId(id);
        if (user.getUserID().equals(id)) {
            throw new IllegalArgumentException("아이디 중복");
        }
        User signUser = new User(id, pw, name, true);
        userDB.insertUser(signUser);
    }

    public User login(String id, String pw) {
        User user = userDB.getUserByUserId(id);
        if (!user.getPassWord().equals(pw)) {
            throw new IllegalArgumentException("비밀번호 불일치");
        }
        return user;
    }

    public User confirmId(String id) {
        return userDB.getUserByUserId(id);
    }

    public void changeUserPw(String id, String pw) {
        User user = confirmId(id);
        user.changeUserPassword(pw);
    }

    public List<Account> getUserAccounts(String id) {
        confirmId(id);
        return accountDB.getAllAccountByUserID(id);
    }

    public void deleteAccount(Account account) {
        accountDB.deleteAccount(account);
        historyDB.deleteHistoriesByAccountNumber(account.getAccountNum());
    }

    public User findUserByAccount(String userAccount) {
        Account OpAccount = accountDB.getAccountByAccountNumber(userAccount);
        return userDB.getUserByUserId(OpAccount.getUserID());
    }

    public ArrayList<Account> getAllAccounts() {
        return accountDB.getAllAccount();
    }

    public ArrayList<History> getAllHistories() {
        return historyDB.getAllHistory();
    }

    public ArrayList<User> getAllUsers() {
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