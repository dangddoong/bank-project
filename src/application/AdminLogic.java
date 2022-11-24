package application;
import data.UserDB;
import data.AccountDB;
import entity.User;

import java.util.Optional;

public class AdminLogic {
    UserDB userDB = new UserDB();

    public String signUp(String name, String id, String pw) {
        Optional<User> opUser = userDB.getUserByUserId(id);
        if(opUser.isPresent()) {
            throw new IllegalArgumentException("아이디 중복");
        }
        User user = new User(name, id, pw, true);
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

    public Optional<User> confirmId(String id){
        for (User user : userDB.getAllUser()) {
            if(user.getUserID().equals(id)){
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public String changeUserPw(String id) {
        Optional<User> user = confirmId(id);
        if(user.isEmpty()){
            throw new IllegalArgumentException("아이디 없음");
        }
        return "변경 성공";
    }

    public String deleteAccount(String userAccount) {
        Optional<Account> account = confirmAccount(userAccount);
        if(account.isEmpty()){
            throw new IllegalArgumentException("계좌 없음");
        }
        AccountDB accountDB = new AccountDB();
        accountDB(account);
        return "삭제 완료";
    }

    public Optional<Account> confirmAccount(String userAccount){
        AccountDB accountDB = new AccountDB();
        for (Account account : accountDB) {
            if (account.getAccountNum().equals(userAccount)) {
                return account;
            }
        }
        return Optional.empty();
    }
}

