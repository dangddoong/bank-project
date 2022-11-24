package application;

import data.UserDB;
import entity.User;

public class UserLogic {
    UserDB userDB = new UserDB();

    public void signUp(String name, String id, String pw) {
        if (userDB.getAllUser() == null) {
            userDB.addAdmin();
        }
        for (User user : userDB.getAllUser()) {
            if (user.getUserID().equals(id)) {
                throw new IllegalArgumentException("아이디 중복");
            }
        }
        User user = new User(name, id, pw);
        userDB.insertUser(user);
    }

    public String login(String id, String pw) {
        for (User user : userDB.getAllUser()) {
            if (!user.getUserID().equals(id)) {
                throw new IllegalArgumentException("아이디 없음");
            }
        }

        for (User user : userDB.getAllUser()) {
            if (!user.getPassWord().equals(pw)) {
                throw new IllegalArgumentException("비밀번호 불일치");
            }
        }
        return "로그인 성공";
    }
}
//        if (id.matches(null)) {
//            System.out.print("존재하지 않는 아이디입니다. ");
//            System.out.print("다시 입력해주세요. ");
//        }
//
//        while (userDB.getUserList(getUserId) != id || userDB.getUserPw(getUserPw) != password) {
//            System.out.print("아이디 또는 비밀번호가 일치하지 않습니다. ");
//            System.out.print("다시 입력해주세요. ");
//        }