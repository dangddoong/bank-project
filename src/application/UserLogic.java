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
                throw new IllegalArgumentException("이미 존재하는 아이디입니다. ");
            }
        }

        User user = new User(name, id, pw);
        userDB.insertUser(user);
    }

    public boolean login(String id, String pw) {

        for (User user : userDB.getAllUser()) {
            if (!user.getUserID().equals(id)) {
                throw new IllegalArgumentException("존재하지 않는 아이디입니다. ");
            }
        }

        for (User user : userDB.getAllUser()) {
            if (!user.getPassWord().equals(pw)) {
                throw new IllegalArgumentException("비밀번호가 일치하지 않습니다. ");
            }
        }
        return true;
    }


    public String Validation() {
        System.out.print("비밀번호를 입력해주세요. : ");
        String pw = scanner.nextLine();

        System.out.print("비밀번호를 다시 입력해주세요. : ");
        String pwValidation = scanner.nextLine();

        if (pw != pwValidation) {
            Validation();
        }
        return pw;
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