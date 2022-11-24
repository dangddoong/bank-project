import data.UserDB;
import entity.User;
public class AdminLogic {
    UserDB userDB = new UserDB();
    public String login(String id, String pw) {
        if(userDB.getAllUser() == null){
            userDB.addAdmin();
        }
        User user = userDB.getAdmin();

        if(!user.getUserID().equals(id)){
            throw new IllegalArgumentException("관리자 아님");
        }

        if(!user.getPassWord().equals(pw)){
            throw new IllegalArgumentException("비밀번호 불일치");
        }
            return "로그인성공";
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
                user.changeByAdmin(pw);
                break;
            }
        }
        return "변경 성공";
    }

    public String deleteAccount(String id) {
        for (User user : userDB.getAllUser()) {
            if (user.getUserID().equals(id)) {
                userDB.deleteToUser(user);
                break;
            }
        }
        return "삭제 완료";
    }

    public User confirmAccount(String Account){
        for (User user : userDB.getAllUser()) {
            if(user.getAccountNum().equals(Account)){
                return user;
            }
        }
        return null;
    }
}

