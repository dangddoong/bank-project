package presentation;

import application.UserLogic;
import entity.User;

import java.util.Scanner;

public class UserUI {
    Scanner scanner = new Scanner(System.in);
    UserLogic userLogic = new UserLogic();
    User loginUser;

    public String userApp(User user) {
        loginUser = user;
        while (true) {
            System.out.println(loginUser.getUserName() + " 님 환영합니다!");
            System.out.println("==== 조미김 은행 회원 페이지 ====");
            System.out.println("1. 입금하기");
            System.out.println("2. 출금하기");
            System.out.println("3. 계좌 정보 조회하기");
            System.out.println("4. 계좌 거래 내역 조회하기");
            System.out.println("5. 계좌 생성하기");
            System.out.println("0. 로그아웃");
            System.out.println("===================================");
            switch (scanner.nextLine()) {
                case "0" -> {
                    return "정상적으로 로그아웃 되었습니다!";
                }
            }
        }
    }
}
