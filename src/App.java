import application.AdminLogic;
import application.UserLogic;
import entity.User;
import presentation.AdminUI;
import presentation.UserUI;

import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static String message = "";
    static AdminUI adminUI = new AdminUI();
    static UserLogic userLogic = new UserLogic();
    static AdminLogic adminLogic = new AdminLogic();
    static UserUI userUI = new UserUI();

    public static void main(String[] args) {
        initData();
        while(true) {
            System.out.println(message);
            System.out.println("======= 조미김 은행에 오신걸 환영합니다 =======");
            System.out.println("1. 회원 가입");
            System.out.println("2. 로그인");
            System.out.println("0. 프로그램 종료");
            System.out.println("=============================================");
            System.out.print("원하시는 작업을 입력해주세요: ");
            switch (scanner.nextLine()) {
                case "1" -> signUp();
                case "2" -> login();
                case "0" -> System.exit(0);
                default -> System.out.println("프로그램을 종료합니다.");
            }
        }
    }

    static void initData() {
        userLogic.signUp("cheolsoo", "cheolsoo", "cheolsoo");
        userLogic.signUp("minhee", "minhee", "cheolsoo");
        userLogic.signUp("minsoo", "minsoo", "minsoo");
        userLogic.signUp("sohee", "sohee", "sohee");
        adminLogic.signUp("admin_sparta", "admin_sparta", "admin_sparta");
        adminLogic.signUp("admin_korea", "admin_korea", "admin_korea");
    }

    static void signUp() {
        System.out.println("회원가입 진행");
        System.out.println("이름 입력");
        String name = scanner.nextLine();
        System.out.println("아이디 입력");
        String id = scanner.nextLine();
        System.out.println("비밀번호 입력");
        String pw = scanner.nextLine();
        if (id.startsWith("admin_")) {
            try {
                message = adminLogic.signUp(name, id, pw);
            } catch (Exception e) {
                if (e.getMessage().equals("아이디 중복")) {
                    message = "아이디가 중복되었습니다!";
                } else {
                    message = "잘못된 입력입니다!";
                }
            }
        } else {
            try {
                message = userLogic.signUp(name, id, pw);
            } catch (Exception e) {
                if (e.getMessage().equals("아이디 중복")) {
                    message = "아이디가 중복되었습니다!";
                } else {
                    message = "잘못된 입력입니다!";
                }
            }
        }
    }

    static void login() {
        System.out.println("로그인 진행");
        System.out.println("아이디 입력");
        String id = scanner.nextLine();
        System.out.println("비밀번호 입력");
        String pw = scanner.nextLine();
        if (id.startsWith("admin_")) {
            try {
                User user = adminLogic.login(id, pw);
                message = adminUI.adminApp(user);
            } catch (Exception e) {
                if (e.getMessage().equals("아이디 중복")) {
                    message = "아이디가 중복되었습니다!";
                } else if(e.getMessage().equals("비밀번호 불일치")) {
                    message = "비밀번호가 틀렸습니다!";
                } else {
                    message = "잘못된 입력입니다!";
                }
            }
        } else {
            try {
                User user = userLogic.login(id, pw);
                message = userUI.userApp(user);
            } catch (Exception e) {
                if (e.getMessage().equals("아이디 중복")) {
                    message = "아이디가 중복되었습니다!";
                } else if(e.getMessage().equals("비밀번호 불일치")) {
                    message = "비밀번호가 틀렸습니다!";
                } else {
                    message = "잘못된 입력입니다!";
                }
            }
        }
    }
}
