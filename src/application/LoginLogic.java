import src.data.UserDB;

import java.util.Scanner;

public class LoginLogic {
    UserDB userDB = new UserDB();
    Scanner scanner = new Scanner(System.in);

    public void login() {
        System.out.print("아이디를 입력하세요 : ");
        String id = scanner.nextLine();

        if (id.matches(null)) {
            System.out.print("존재하지 않는 아이디입니다. ");
            System.out.print("다시 입력해주세요. ");
        }
        id = scanner.nextLine();

        System.out.print("비밀번호를 입력하세요 : ");
        String password = scanner.nextLine();

        while (userDB.getUserList(getUserId) != id || userDB.getUserPw(getUserPw) != password) {
            System.out.print("아이디 또는 비밀번호가 일치하지 않습니다. ");
            System.out.print("다시 입력해주세요. ");
            id = scanner.nextLine();
            password = scanner.nextLine();
        }
        System.out.println("로그인 성공");
    }
}
