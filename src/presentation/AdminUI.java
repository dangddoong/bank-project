package presentation;

import java.util.Scanner;

public class AdminUI {
    Scanner scanner = new Scanner(System.in);

    public void login() {
        System.out.println("로그인 진행");
        System.out.println("아이디 입력");
        String id = scanner.nextLine();
        System.out.println("비밀번호 입력");
        String pw = scanner.nextLine();
        // service.login(id, pw);
        // adminApp();
    }

    public void userApp() {
        while(true) {
            System.out.println("==== 조미김 은행 관리자 페이지 ====");
            System.out.println("1. 사용자 정보 수정");
            System.out.println("2. 사용자 정보 삭제");
            System.out.println("3. 계좌번호로 사용자 찾기");
            System.out.println("4. 소유자명으로 계좌 찾기");
            System.out.println("5. 은행 내 모든 계좌 조회");
            System.out.println("0. 로그아웃");
            switch (scanner.nextLine()) {
                case "0" -> {
                    return;
                }
            }
        }
    }
}
