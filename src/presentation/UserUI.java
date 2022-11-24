package presentation;

import UserLogic;

import java.util.Scanner;

public class UserUI {
    Scanner scanner = new Scanner(System.in);
    UserLogic userLogic = new UserLogic();

    public void signUp() {
        System.out.println("회원가입 진행");
        System.out.println("이름 입력");
        String name = scanner.nextLine();
        System.out.println("아이디 입력");
        String id = scanner.nextLine();
        System.out.println("비밀번호 입력");
        String pw = scanner.nextLine();
        try {
            userLogic.signUp(name, id, pw);
        } catch () {
        }
    }

    public void login() {
        boolean isLogin = false;

        System.out.println("로그인 진행");
        System.out.println("아이디 입력");
        String id = scanner.nextLine();
        System.out.println("비밀번호 입력");
        String pw = scanner.nextLine();

        try {
            isLogin = userLogic.login(id, pw);
        } catch () {

        }
        if(isLogin == true) {
            userApp();
        }
    }

    public void userApp() {
        while(true) {
            System.out.println("==== 조미김 은행 회원 페이지 ====");
            System.out.println("1. 입금 하기");
            System.out.println("2. 출금 하기");
            System.out.println("3. 계좌 정보 조회");
            System.out.println("4. 계좌 거래 내역");
            System.out.println("5. ");
            System.out.println("6. ");
            System.out.println("0. 로그아웃");
            switch (scanner.nextLine()) {
                case "0" -> {
                    return;
                }
            }

        }
    }
}
