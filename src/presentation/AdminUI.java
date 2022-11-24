package presentation;

import application.AdminLogic;
import entity.User;

import java.util.Scanner;

public class AdminUI {
    Scanner scanner = new Scanner(System.in);
    AdminLogic adminLogic = new AdminLogic();
    User loginUser;
    String message = "";

    public String adminApp(User user) {
        loginUser = user;
        while (true) {
            System.out.println(message);
            System.out.println(loginUser.getUserName() + " 관리자님 환영합니다!");
            System.out.println("==== 조미김 은행 관리자 페이지 ====");
            System.out.println("1. 사용자 정보 수정");//사용자 id와 변경할 비밀번호 필요
            System.out.println("2. 사용자 정보 삭제"); //사용자 id필요 <= 검증 로직(id가 없으면 exception) + 삭제 로직
            System.out.println("3. 계좌번호로 사용자 찾기");
            System.out.println("4. 소유자명으로 계좌 찾기");
            System.out.println("5. 은행 내 모든 계좌 조회");
            System.out.println("0. 로그아웃");
            System.out.println("===================================");
            switch (scanner.nextLine()) {
                case "1" -> message = "asd";
                case "2" -> message = "asdf";
                case "0" -> {
                    return "정상적으로 로그아웃 되었습니다!";
                }
                default -> message = "잘못된 입력입니다.";
            }
        }
    }
}
