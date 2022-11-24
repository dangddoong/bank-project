package application;
import data.UserDB;
import entity.User;
public class AdminLogic {
    UserDB userDB = new UserDB();
    public boolean login(String id, String pw) {
        if(userDB.getAllUser() == null){
            userDB.addAdmin();
        }
        User user = userDB.getAdmin();

        if(user.getUserID() != id){
            throw new IllegalArgumentException("관리자가 아닙니다.");
        }

        if(user.getPassWord() != pw){
            throw new IllegalArgumentException("비밀번호가 틀렸습니다. 다시 입력해수제요");
        }
            return true;
        }

}
