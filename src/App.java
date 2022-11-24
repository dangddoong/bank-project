import presentation.AdminUI;
import presentation.UserUI;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdminUI adminUI = new AdminUI();
        UserUI userUI = new UserUI();

        while(true) {
            System.out.println("======= 조미김 은행에 오신걸 환영합니다 =======");
            System.out.println("1. 회원 가입");
            System.out.println("2. 회원 로그인");
            System.out.println("3. 관리자 로그인");
            System.out.println("0. 프로그램 종료");
            System.out.println("=============================================");
            System.out.print("원하시는 작업을 입력해주세요: ");
            switch (scanner.nextLine()) {
                case "1" -> userUI.signUp();
                case "2" -> userUI.login();
                case "3" -> adminUI.login();
                case "0" -> System.exit(0);
                default -> System.out.println("프로그램을 종료합니다.");
            }
        }
    }
}
