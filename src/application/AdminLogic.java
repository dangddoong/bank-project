package application;
import data.UserDB;
import entity.User;
public class AdminLogic {
    UserDB userDB = new UserDB();
    public String login(String id, String pw) {
        if(userDB.getAllUser() == null){
            userDB.addAdmin();
        }
        User user = userDB.getAdmin();

        if(user.getUserID() != id){
            throw new IllegalArgumentException("관리자 아님");
        }

        if(user.getPassWord() != pw){
            throw new IllegalArgumentException("비밀번호 불일치");
        }
            return "로그인성공";
        }

}
