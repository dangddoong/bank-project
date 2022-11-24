package application;

import data.UserDB;
import entity.User;
public class AdminLogic {
    public boolean login(String id, String pw) {
       UserDB userDB = new UserDB();
        if(userDB.getAdminid() != id){
            throw new IllegalArgumentException("관리자가 아닙니다.");
        }

        if(UserDB.getAdminpw() != pw){
            throw new IllegalArgumentException("비밀번호가 틀렸습니다. 다시 입력해수제요");
        }
            return true;
        }

}
