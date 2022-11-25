package application;

import data.AccountDB;
import data.HistoryDB;
import data.UserDB;
import entity.User;

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
}