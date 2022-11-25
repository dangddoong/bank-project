package application;

import data.UserDB;
import data.AccountDB;
import entity.User;
import entity.Account;
import entity.History;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import data.HistoryDB;

import static application.TradeType.출금;

public class UserLogic {
    HistoryDB historyDB = new HistoryDB()
    UserDB userDB = new UserDB();
    AccountDB accountDB = new AccountDB();
    public String signUp(String name, String id, String pw) {
        Optional<User> opUser = userDB.getUserByUserId(id);
        if(opUser.isPresent()) {
            throw new IllegalArgumentException("아이디 중복");
        }
        User user = new User(id, pw, name, false);
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

    public List<Account>findAccountInfo(User user){
        List<Account> accounts = accountDB.getAllAccount().stream().
                filter(id -> id.getUserID()
                        .equals(user.getUserID()))
                .collect(Collectors.toList());
        return  accounts;
    }

    public History createWithdrawHistory(Account accounts, String money){
        History history = new History(accounts.getAccountNum(), TradeType.출금, money,"조미김 은행");
        historyDB.insertHistory(history);
        return history;
    }
}