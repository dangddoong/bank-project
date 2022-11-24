package application;
import data.UserDB;
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

    public boolean confirmId(String id){
        for (User user : userDB.getAllUser()) {
            if(user.getUserID().equals(id)){
                return true;
            }
        }
        return false;
    }

    public String changeUserPw(String pw, String id) {
        for (User user : userDB.getAllUser()) {
            if(user.getUserID().equals(id)){
                break;
            }
        }
        return "변경 성공";
    }

    public String deleteAccount(String id) {
        for (User user : userDB.getAllUser()) {
            if (user.getUserID().equals(id)) {
                break;
            }
        }
        return "삭제 완료";
    }

    public User confirmAccount(String Account){
        for (User user : userDB.getAllUser()) {
        }
        return null;
    }
}

